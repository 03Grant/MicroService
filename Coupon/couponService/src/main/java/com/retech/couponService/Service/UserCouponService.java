package com.retech.couponService.Service;

import com.retech.couponService.DTO.AllocCoupon;
import org.springframework.stereotype.Service;

@Service
public interface UserCouponService {
    boolean allocateCouponToUser(AllocCoupon allocCoupon);
}
