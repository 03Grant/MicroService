package com.retech.commodityService.DTO;



public class QuantityDTO {
    private String commodityId;
    private String configurationId;
    private String warehouse;
    private int quantity;

    // Constructors, getters, and setters

    public QuantityDTO() {
    }

    public QuantityDTO(String commodityId, String configurationId, String warehouse, int quantity) {
        this.commodityId = commodityId;
        this.configurationId = configurationId;
        this.warehouse = warehouse;
        this.quantity = quantity;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(String configurationId) {
        this.configurationId = configurationId;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "QuantityDTO{" +
                "commodityId='" + commodityId + '\'' +
                ", configurationId='" + configurationId + '\'' +
                ", warehouse='" + warehouse + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
