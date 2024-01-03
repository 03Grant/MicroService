package com.retech.orderservice.Model;

public class orderoffer {
    private String orderId;
    private String couponId;
    private double couponAmount;

    // Constructors

    public orderoffer() {
        // Default constructor
    }

    public orderoffer(String orderId, String couponId, double couponAmount) {
        this.orderId = orderId;
        this.couponId = couponId;
        this.couponAmount = couponAmount;
    }

    // Getters and Setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(double couponAmount) {
        this.couponAmount = couponAmount;
    }

    // toString() method for debugging or logging purposes

    @Override
    public String toString() {
        return "OrderOffer{" +
                "orderId='" + orderId + '\'' +
                ", couponId='" + couponId + '\'' +
                ", couponAmount=" + couponAmount +
                '}';
    }
}
