package com.retech.userService.Controller;


import com.retech.userService.Model.UserCoupon;
import com.retech.userService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usercoupon")
public class UserCouponController {

    private final UserService userService;

    @Autowired
    public UserCouponController(UserService userService) {
        this.userService = userService;
    }

    // 获取用户的所有优惠券信息
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserCoupon>> getUserCoupons(@PathVariable String userId) {
        List<UserCoupon> coupons = userService.getUserCoupons(userId);

        //todo 根据coupon的id，从coupon微服务中获取优惠券信息。
        if (coupons != null && !coupons.isEmpty()) {
            return ResponseEntity.ok(coupons);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 增加用户的优惠券(被调用)
    @PostMapping("/add")
    public ResponseEntity<?> addCoupons(@RequestBody UserCoupon userCoupon) {
        boolean isSuccess = userService.addCoupons(userCoupon);
        if (isSuccess) {
            return ResponseEntity.ok("Coupons added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add coupons");
        }
    }

    // 减少用户的优惠券（被订单微服务调用）
    @PostMapping("/remove")
    public ResponseEntity<?> removeCoupons(@RequestBody UserCoupon userCoupon) {
        boolean isSuccess = userService.removeCoupons(userCoupon);
        if (isSuccess) {
            return ResponseEntity.ok("Coupons removed successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to remove coupons or insufficient coupons");
        }
    }
}

