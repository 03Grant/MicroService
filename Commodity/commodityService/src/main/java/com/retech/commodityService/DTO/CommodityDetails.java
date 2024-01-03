package com.retech.commodityService.DTO;

public class CommodityDetails {
    private String commodityid;
    private String commodityname;
    private String brand;
    private String configurationid;
    private String CPU;
    private String GPU;
    private String disk;
    private String memory;
    private double price;

    private int quantity;
    // 构造函数、getter 和 setter 方法

    public CommodityDetails() {
        // 默认构造函数
    }

    public CommodityDetails(String commodityid, String commodityname, String brand, String configurationid, String CPU, String GPU, String disk, String memory, double price,int quantity)  {
        this.commodityid = commodityid;
        this.commodityname = commodityname;
        this.brand = brand;
        this.configurationid = configurationid;
        this.CPU = CPU;
        this.GPU = GPU;
        this.disk = disk;
        this.memory = memory;
        this.price = price;
        this.quantity=quantity;
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

    public String getConfigurationid() {
        return configurationid;
    }

    public void setConfigurationid(String configurationid) {
        this.configurationid = configurationid;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

