package com.retech.couponService.Model;
import java.sql.Timestamp;

public class Coupon {
    public String couponid;
    public String couponname;
    public String commatch;
    public String type;
    public double discount;
    public double limit;
    public double specialoffer;
    public boolean cumulation;
    public Timestamp timebegin;
    public Timestamp timeend;
    public int tot_num;
}
