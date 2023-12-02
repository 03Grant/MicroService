// CommodityInfo.java

package com.retech.commodityService.DTO;

public class CommodityInfo {
    private String commodityId;
    private String commodityName;
    private String brand;
    private double minPrice;
    private double maxPrice;

    // 构造函数、getter 和 setter 方法

    public CommodityInfo() {
        // 默认构造函数
    }

    public CommodityInfo(String commodityId, String commodityName, String brand, double minPrice, double maxPrice) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.brand = brand;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
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
