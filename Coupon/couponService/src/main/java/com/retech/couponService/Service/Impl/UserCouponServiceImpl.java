package com.retech.couponService.Service.Impl;

import com.retech.couponService.Mapper.UserCouponMapper;
import com.retech.couponService.DTO.AllocCoupon;
import com.retech.couponService.Service.UserCouponService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

@Service
public class UserCouponServiceImpl implements UserCouponService {
    private final SqlSessionFactory sqlSessionFactory;

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
