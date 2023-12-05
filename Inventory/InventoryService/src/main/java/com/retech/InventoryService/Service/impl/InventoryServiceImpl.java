package com.retech.InventoryService.Service.impl;

import com.retech.InventoryService.DTO.QueryInventory;
import com.retech.InventoryService.Mapper.InventoryMapper;
import com.retech.InventoryService.Model.Inventory;
import com.retech.InventoryService.Service.InventoryService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;
//import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final SqlSessionFactory sqlSessionFactory;

    public InventoryServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public boolean addInventory(Inventory inventory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            if(inventory.getQuantity() <=0){
                return false;
            }
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            int affectedRows = mapper.insertInventory(inventory);
            session.commit();
            return affectedRows > 0; // 如果影响的行数大于0，则返回true
        }
    }

    @Override
   // @Transactional
    public boolean updateInventory(Inventory inventory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            if (inventory.getQuantity() <= 0) {
                return false;
            }
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);

            // 获取现有库存信息
            Inventory existingInventory = mapper.getInventoryByCommodityAndConfiguration(inventory.getCommodityid(), inventory.getConfigurationid(), inventory.getWarehouse());

            // 如果找不到库存信息，创建一个新的库存记录
            if (existingInventory == null) {
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

    // 按需查询
    @Override
    public List<Inventory> queryInventory(QueryInventory queryInventory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            return mapper.queryInventory(queryInventory);
        }
    }

    //减少库存
    @Override
    public boolean decreaseInventory(Inventory inventory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            InventoryMapper mapper = session.getMapper(InventoryMapper.class);
            int affectedRows = mapper.decreaseInventory(inventory);
            session.commit();
            return affectedRows > 0;
        }
    }
}