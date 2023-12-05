package com.retech.InventoryService.Mapper;

import com.retech.InventoryService.DTO.QueryInventory;
import com.retech.InventoryService.Model.Inventory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InventoryMapper {

    int insertInventory(Inventory inventory);
    int updateInventory(Inventory inventory);
    Inventory getInventoryByCommodityAndConfiguration(@Param("commodityid") String commodityid, @Param("configurationid") String configurationid, @Param("warehouse") String warehouse);
    List<Inventory> queryInventory(QueryInventory queryInventory);
    int decreaseInventory(Inventory inventory);
}
