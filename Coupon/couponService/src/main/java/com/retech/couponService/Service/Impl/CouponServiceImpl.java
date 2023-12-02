package com.retech.couponService.Service.Impl;

import com.retech.couponService.Mapper.CouponMapper;
import com.retech.couponService.Model.Coupon;
import com.retech.couponService.Service.CouponService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    //导入配置文件
    private final SqlSessionFactory sqlSessionFactory;

    @Autowired
    public CouponServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    @Override
    public boolean addCoupon(Coupon coupon) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CouponMapper mapper = session.getMapper(CouponMapper.class);
            int result = mapper.insertCoupon(coupon);
            session.commit();
            return result > 0;
        } catch (Exception e) {
            // 处理异常
            return false;
        }
    }

    @Override
    public boolean updateCoupon(Coupon coupon) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CouponMapper mapper = session.getMapper(CouponMapper.class);
            int result = mapper.updateCoupon(coupon);
            session.commit();
            return result > 0;
        } catch (Exception e) {
            // 异常处理
            return false;
        }
    }

    @Override
    public boolean deleteCoupon(String couponid) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CouponMapper mapper = session.getMapper(CouponMapper.class);
            int result = mapper.deleteCoupon(couponid);
            session.commit();
            return result > 0;
        } catch (Exception e) {
            // 异常处理
            return false;
        }
    }

    @Override
    public List<Coupon> findActiveCoupons() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CouponMapper mapper = session.getMapper(CouponMapper.class);
            return mapper.findActiveCoupons();
        } catch (Exception e) {
            // 异常处理
            return null;
        }
    }

    @Override
    public List<Coupon> findExpiredCoupons() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CouponMapper mapper = session.getMapper(CouponMapper.class);
            return mapper.findExpiredCoupons();
        } catch (Exception e) {
            // 异常处理
            return null;
        }
    }

    @Override
    public List<Coupon> findNotYetActiveCoupons() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CouponMapper mapper = session.getMapper(CouponMapper.class);
            return mapper.findNotYetActiveCoupons();
        } catch (Exception e) {
            // 异常处理
            return null;
        }
    }

    @Override
    public Coupon findCouponById(String couponid) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CouponMapper mapper = session.getMapper(CouponMapper.class);
            return mapper.findCouponById(couponid);
        } catch (Exception e) {
            // 异常处理
            return null;
        }
    }

}
