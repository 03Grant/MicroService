package com.retech.couponService.Mapper;

import com.retech.couponService.Model.Coupon;

import java.util.List;

public interface CouponMapper {
    int insertCoupon(Coupon coupon);
    int updateCoupon(Coupon coupon);
    int deleteCoupon(String couponid);
    List<Coupon> findActiveCoupons();
    // 过期优惠券
    List<Coupon> findExpiredCoupons();
    // 未开始生效的优惠券
    List<Coupon> findNotYetActiveCoupons();
    Coupon findCouponById(String couponid);
}
