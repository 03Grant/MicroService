package com.retech.userService.Service;

import com.retech.userService.Model.Address;
import com.retech.userService.Model.User;
import com.retech.userService.DTO.LogInfo;
import com.retech.userService.Model.UserCoupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    // 登录检查
    User checkUser(LogInfo loginfo);

    // 获取用户的收获地址
    List<Address> getAddressesByUserId(String userid);

    // 增加用户的收货地址
    boolean addAddress(Address address);


    // 增加用户优惠券
    boolean addCoupons(UserCoupon userCoupon);

    // 减少用户优惠券
    boolean removeCoupons(UserCoupon userCoupon);

    // 获取用户优惠券信息
    List<UserCoupon> getUserCoupons(String userid);


}
