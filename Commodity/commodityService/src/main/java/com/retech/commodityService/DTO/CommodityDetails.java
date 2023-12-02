package com.retech.commodityService.DTO;

public class CommodityDetails {
    private String commodityId;
    private String commodityName;
    private String brand;
    private String configurationId;
    private String CPU;
    private String GPU;
    private String disk;
    private String memory;
    private double price;

    // 构造函数、getter 和 setter 方法

    public CommodityDetails() {
        // 默认构造函数
    }

    public CommodityDetails(String commodityId, String commodityName, String brand, String configurationId, String CPU, String GPU, String disk, String memory, double price) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.brand = brand;
        this.configurationId = configurationId;
        this.CPU = CPU;
        this.GPU = GPU;
        this.disk = disk;
        this.memory = memory;
        this.price = price;
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

    public String getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(String configurationId) {
        this.configurationId = configurationId;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

