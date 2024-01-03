package com.retech.orderservice.Model;

public class orderoffer {
    private String orderid;
    private String couponid;
    private double coupon_amount;

    // Constructors

    public orderoffer() {
        // Default constructor
    }

    public orderoffer(String orderid, String couponid, double coupon_amount) {
        this.orderid = orderid;
        this.couponid = couponid;
        this.coupon_amount = coupon_amount;
    }

    // Getters and Setters

    public String getOrderid() {
        return orderid;
    }

    public void setOrderId(String orderid) {
        this.orderid = orderid;
    }

    public String getCouponId() {
        return couponid;
    }

    public void setCouponId(String couponid) {
        this.couponid = couponid;
    }

    public double getcoupon_amount() {
        return coupon_amount;
    }

    public void setcoupon_amount(double coupon_amount) {
        this.coupon_amount = coupon_amount;
    }

    // toString() method for debugging or logging purposes

    @Override
    public String toString() {
        return "OrderOffer{" +
                "orderid='" + orderid + '\'' +
                ", couponid='" + couponid + '\'' +
                ", coupon_amount=" + coupon_amount +
                '}';
    }
}
