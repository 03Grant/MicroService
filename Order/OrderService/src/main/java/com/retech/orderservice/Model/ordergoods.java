package com.retech.orderservice.Model;

public class ordergoods {
    private String orderid;
    private String commodityid;
    private int commoditynum;

    // Constructors

    public ordergoods() {
        // Default constructor
    }

    public ordergoods(String orderid, String commodityid, int commoditynum) {
        this.orderid = orderid;
        this.commodityid = commodityid;
        this.commoditynum = commoditynum;
    }

    // Getters and Setters

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

    public int getCommoditynum() {
        return commoditynum;
    }

    public void setCommoditynum(int commoditynum) {
        this.commoditynum = commoditynum;
    }

    // toString() method for debugging or logging purposes

    @Override
    public String toString() {
        return "ordergoods{" +
                "orderid='" + orderid + '\'' +
                ", commodityid='" + commodityid + '\'' +
                ", commoditynum=" + commoditynum +
                '}';
    }
}

