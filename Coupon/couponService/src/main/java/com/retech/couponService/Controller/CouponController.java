package com.retech.couponService.Controller;

import com.retech.couponService.Model.Coupon;
import com.retech.couponService.Service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/add")
    public boolean addCoupon(@RequestBody Coupon coupon) {
        // todo 一些优惠券确认逻辑。
        return couponService.addCoupon(coupon);
    }

    @PutMapping("/update")
    public boolean updateCoupon(@RequestBody Coupon coupon) {
        return couponService.updateCoupon(coupon);
    }

    @DeleteMapping("/delete/{couponid}")
    public boolean deleteCoupon(@PathVariable String couponid) {
        return couponService.deleteCoupon(couponid);
    }

    // 查询未过期的优惠券
    @GetMapping("/active")
    public List<Coupon> findActiveCoupons() {
        return couponService.findActiveCoupons();
    }

    @GetMapping("/expired")
    public List<Coupon> findExpiredCoupons() {
        return couponService.findExpiredCoupons();
    }

    @GetMapping("/notyetactive")
    public List<Coupon> findNotYetActiveCoupons() {
        return couponService.findNotYetActiveCoupons();
    }

    @GetMapping("/{couponid}")
    public Coupon findCouponById(@PathVariable String couponid) {
        return couponService.findCouponById(couponid);
    }


}
