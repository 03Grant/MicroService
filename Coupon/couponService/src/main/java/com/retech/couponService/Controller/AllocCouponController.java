package com.retech.couponService.Controller;

import com.retech.couponService.DTO.AllocCoupon;
import com.retech.couponService.Service.UserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/user-coupons")
public class AllocCouponController {

    @Autowired
    private UserCouponService userCouponService;

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @PostMapping("/allocate")
    public boolean allocateCouponToUser(@RequestBody AllocCoupon allocCoupon) {
        // 目前一次限制领一张
        allocCoupon.setNum(1);
        // todo: 可以加一些检验的代码。
        String userServiceUrl = "http://USERSERVICE/usercoupon/add"; // 替换为实际的 URL
        // 发送 POST 请求
        ResponseEntity<Boolean> response = restTemplate.postForEntity(userServiceUrl, allocCoupon, Boolean.class);
        // 返回结果
        return response.getBody() != null && response.getBody();
    }
}
