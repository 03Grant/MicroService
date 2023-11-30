package com.retech.couponService.Controller;

import com.retech.couponService.DTO.AllocCoupon;
import com.retech.couponService.Service.UserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-coupons")
public class AllocCouponController {

    @Autowired
    private UserCouponService userCouponService;

    @PostMapping("/allocate")
    public boolean allocateCouponToUser(@RequestBody AllocCoupon allocCoupon) {
        return userCouponService.allocateCouponToUser(allocCoupon);
    }
}
