package com.retech.couponService.Service.Impl;

import com.retech.couponService.Mapper.UserCouponMapper;
import com.retech.couponService.DTO.AllocCoupon;
import com.retech.couponService.Service.UserCouponService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class UserCouponServiceImpl implements UserCouponService {
    private final SqlSessionFactory sqlSessionFactory;

    @Autowired
    public UserCouponServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public boolean allocateCouponToUser(AllocCoupon allocCoupon) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserCouponMapper mapper = session.getMapper(UserCouponMapper.class);
            int result = mapper.allocateCouponToUser(allocCoupon);
            session.commit();
            return result > 0;
        } catch (Exception e) {
            // 异常处理
            return false;
        }
    }
}
