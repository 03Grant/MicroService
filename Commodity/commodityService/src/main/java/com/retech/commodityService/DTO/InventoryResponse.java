package com.retech.commodityService.DTO;

public class InventoryResponse {
    private String commodityid;
    private String configurationid;
    private String warehouse;
    private Integer quantity;

    // 确保有一个公开的 getQuantity 方法
    public Integer getQuantity() {
        return quantity;
    }

    // 其他 getters 和 setters
}
