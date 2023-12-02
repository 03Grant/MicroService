package com.retech.couponService.DTO;

public class AllocCoupon {
    private String userid;
    private String couponid;
    private int num;

    // Getters and Setters
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCouponid() {
        return couponid;
    }

    public void setCouponid(String couponid) {
        this.couponid = couponid;
    }
    public int getNum(){
        return num;
    }
    public void setNum(int num){
        this.num=num;
    }
}
