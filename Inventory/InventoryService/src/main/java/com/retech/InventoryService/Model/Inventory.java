package com.retech.InventoryService.Model;

public class Inventory {
    private String commodityid;
    private String commodityname;
    private String warehouse;
    private int quantity;


    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setcommodityname(String commodityname) {
        this.commodityname = commodityname;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouseid) {
        this.warehouse = warehouseid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
