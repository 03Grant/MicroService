package com.retech.InventoryService.Service.impl;

import com.retech.InventoryService.DTO.QueryInventory;
import com.retech.InventoryService.Mapper.InventoryMapper;
import com.retech.InventoryService.Model.Inventory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import com.retech.InventoryService.Service.InventoryService;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final SqlSessionFactory sqlSessionFactory;
    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public InventoryServiceImpl(SqlSessionFactory sqlSessionFactory, RedisTemplate<String, String> redisTemplate) {
        this.sqlSessionFactory = sqlSessionFactory;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean addInventory(Inventory inventory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            if (inventory.getQuantity() <= 0) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventory not found");
            }
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            int affectedRows = mapper.insertInventory(inventory);
            session.commit();
            return affectedRows > 0; // 如果影响的行数大于0，则返回true
        }
    }

    @Override
    public boolean updateInventory(Inventory inventory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);

            // 获取现有库存信息
            Inventory existingInventory = mapper.getInventoryByCommodityAndConfiguration(
                    inventory.getCommodityid(), inventory.getCommodityname(), inventory.getWarehouse());

            // 如果找不到库存信息，创建一个新的库存记录
            if (existingInventory == null) {
                if (inventory.getQuantity() <= 0) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventory not found");
                }
                int affectedRows = mapper.insertInventory(inventory);
                session.commit();
                return affectedRows > 0;
            }

            // 否则，更新现有库存
            existingInventory.setQuantity(existingInventory.getQuantity() + inventory.getQuantity());
            int affectedRows = mapper.updateInventory(existingInventory);
            session.commit();
            return affectedRows > 0;
        }
    }

    @Override
    public List<Inventory> queryInventory(QueryInventory queryInventory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            return mapper.queryInventory(queryInventory);
        }
    }

    @Override
    public boolean decreaseInventory(Inventory inventory) {
        // Redis distributed lock key
        String lockKey = "inventory_lock:" + inventory.getCommodityid();

        // Acquire lock
        boolean locked = acquireLock(lockKey);
        if (!locked) {
            // Failed to acquire lock, handle accordingly (throw exception, return false, etc.)
            return false;
        }

        try (SqlSession session = sqlSessionFactory.openSession()) {
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            int affectedRows = mapper.decreaseInventory(inventory);
            session.commit();
            return affectedRows > 0;
        } finally {
            // Release lock
            releaseLock(lockKey);
        }
    }

    private boolean acquireLock(String lockKey) {
        // Use Redis SETNX to acquire lock
        return redisTemplate.opsForValue().setIfAbsent(lockKey, "LOCKED", 10, TimeUnit.SECONDS);
    }

    private void releaseLock(String lockKey) {
        // Release lock by deleting the key
        redisTemplate.delete(lockKey);
    }
}
