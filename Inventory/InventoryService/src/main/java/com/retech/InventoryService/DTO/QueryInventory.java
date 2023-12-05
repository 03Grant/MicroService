package com.retech.InventoryService.DTO;

public class QueryInventory {
    private String commodityid;
    private String configurationid;
    private String warehouse;

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

    public String getConfigurationid() {
        return configurationid;
    }

    public void setConfigurationid(String configurationid) {
        this.configurationid = configurationid;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }
}
