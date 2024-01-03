package com.retech.orderservice.DTO;
import java.sql.Timestamp;

public class Order {
    private String userid;
    private String orderid;
    private String commodityid;

    private Timestamp time;
    private String status;
    private double tot_amount;
    private double coupon_amount; // 添加此行
    private String couponid; // 添加此行
    private int  commoditynum;


    public Order() {
    }

    public Order(String userid, String orderid, String commodityid,
                 Timestamp time, String status, double tot_amount, double coupon_amount, int commoditynum, String couponid) {
        this.userid = userid;
        this.orderid = orderid;
        this.commodityid = commodityid;
        this.commoditynum = commoditynum;
        this.time = time;
        this.status = status;
        this.tot_amount = tot_amount;
        this.coupon_amount = coupon_amount;
        this.couponid = couponid;
    }

    // Getters and Setters for all fields

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

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


    public void setCommoditynum(int commoditynum) {
        this.commoditynum = commoditynum;
    }

    public int getCommoditynum() {
        return commoditynum;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public double getTot_amount() {
        return tot_amount;
    }

    public void setTot_amount(int tot_amount) {
        this.tot_amount = tot_amount;
    }

    public double getCoupon_amount() {
        return coupon_amount;
    }

    public void setCoupon_amount(double coupon_amount) {
        this.coupon_amount = coupon_amount;
    }

    public String getCouponid() {
        return couponid;
    }

    public void setCouponid(String couponid) {
        this.couponid = couponid;
    }

    // Additional methods, if needed

    @Override
    public String toString() {
        return "Order{" +
                "userid='" + userid + '\'' +
                ", orderid='" + orderid + '\'' +
                ", commodityid='" + commodityid + '\'' +
                ", time=" + time +
                ", status='" + status + '\'' +
                ", tot_amount=" + tot_amount +
                ", coupon_amount=" + coupon_amount +
                ", couponid='" + couponid + '\'' +
                '}';
    }
}
