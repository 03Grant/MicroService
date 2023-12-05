package com.retech.InventoryService.Service;

import com.retech.InventoryService.DTO.QueryInventory;
import com.retech.InventoryService.Model.Inventory;

import java.util.List;

public interface InventoryService {
    boolean addInventory(Inventory inventory);
    boolean updateInventory(Inventory inventory);
    List<Inventory> queryInventory(QueryInventory queryInventory);
    boolean decreaseInventory(Inventory inventory);
}


