// CommodityInfo.java

package com.retech.commodityService.DTO;

public class CommodityInfo {
    private String commodityid;
    private String commodityname;
    private String brand;
    private double minPrice;
    private double maxPrice;

    // 构造函数、getter 和 setter 方法

    public CommodityInfo() {
        // 默认构造函数
    }

    public CommodityInfo(String commodityid, String commodityname, String brand, double minPrice, double maxPrice) {
        this.commodityid = commodityid;
        this.commodityname = commodityname;
        this.brand = brand;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }
}
