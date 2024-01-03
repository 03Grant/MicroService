package com.retech.InventoryService.Controller;


import com.retech.InventoryService.DTO.QueryInventory;
import com.retech.InventoryService.Model.Inventory;
import com.retech.InventoryService.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private RestTemplate restTemplate;
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // 增加一条新的库存信息
    @PostMapping("/add")
    public ResponseEntity<?> addInventory(@RequestBody Inventory inventory) {

//        // PRODUCT 对应注册Eureka中的服务名字
//        String url = "http://InventoryService/InventoryService/inventory/add";

        boolean isSuccess = inventoryService.addInventory(inventory);
        if (isSuccess) {
            return ResponseEntity.ok("Inventory added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add inventory");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory) {
        boolean isSuccess = inventoryService.updateInventory(inventory);
        if (isSuccess) {
            return ResponseEntity.ok("Inventory updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update inventory");
        }
    }

    @GetMapping("/query")
    public List<Inventory> queryInventory(QueryInventory queryInventory) {
        return inventoryService.queryInventory(queryInventory);
    }

    @PostMapping("/decrease")
    public ResponseEntity<?> decreaseInventory(@RequestBody Inventory inventory) {
        boolean isSuccess =  inventoryService.decreaseInventory(inventory);
        if (isSuccess) {
            return ResponseEntity.ok("Inventory decreased successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to decrease inventory");
        }
    }
}
