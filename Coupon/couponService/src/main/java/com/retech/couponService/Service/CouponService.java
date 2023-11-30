package com.retech.couponService.Service;

import com.retech.couponService.Model.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CouponService {
    boolean addCoupon(Coupon coupon);
    boolean updateCoupon(Coupon coupon);
    boolean deleteCoupon(String couponid);
    List<Coupon> findActiveCoupons();
    List<Coupon> findExpiredCoupons();
    List<Coupon> findNotYetActiveCoupons();
    Coupon findCouponById(String couponid);
}
