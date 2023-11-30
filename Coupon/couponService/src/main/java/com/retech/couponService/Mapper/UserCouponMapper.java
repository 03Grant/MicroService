package com.retech.couponService.Mapper;

import com.retech.couponService.DTO.AllocCoupon;

public interface UserCouponMapper {
    int allocateCouponToUser(AllocCoupon allocCoupon);
}
