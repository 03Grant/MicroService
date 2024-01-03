package com.retech.commodityService.Model;

public class Commodity{
    public String commodityid;
    public String commodityname;
    public String brand;

    public int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type= type;
    }

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname;
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}