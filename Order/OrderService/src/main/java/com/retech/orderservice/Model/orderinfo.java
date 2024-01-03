package com.retech.orderservice.Model;
import java.sql.Timestamp;
public class orderinfo {
    private String orderid;
    private String userid;
    private Timestamp time;
    private String status;
    private double total_amount;

    // Constructors

    public orderinfo() {
        // Default constructor
    }

    public orderinfo(String orderid, String userid, Timestamp time, String status, double total_amount) {
        this.orderid = orderid;
        this.userid = userid;
        this.time = time;
        this.status = status;
        this.total_amount = total_amount;
    }

    // Getters and Setters

    public String getorderid() {
        return orderid;
    }

    public void setorderid(String orderid) {
        this.orderid = orderid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    // toString() method for debugging or logging purposes

    @Override
    public String toString() {
        return "orderinfo{" +
                "orderid='" + orderid + '\'' +
                ", userid='" + userid + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", total_amount=" + total_amount +
                '}';
    }
}
