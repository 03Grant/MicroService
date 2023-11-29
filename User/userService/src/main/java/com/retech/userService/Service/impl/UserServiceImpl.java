package com.retech.userService.Service.impl;

import com.retech.userService.DTO.LogInfo;
import com.retech.userService.Model.Address;
import com.retech.userService.Model.User;
import com.retech.userService.Model.UserCoupon;
import com.retech.userService.Service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    //导入配置文件
    String config = "userDBconfig.xml";
    //将配置文件转换成stream
    InputStream inputStream = Resources.getResourceAsStream(config);
    public UserServiceImpl() throws IOException {
    }

    //每个Mybatis都必须具备的SqlSessionFactory。使用一个SqlSessionFactory建造器，通过将转换的配置流交给建造器建造起SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    //建造完成后，再把Session给打开就可以使用SqlSession进行数据库操作（即openSession）

    @Override
    public User checkUser(LogInfo loginfo) {
        User result = new User();
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            result = sqlSession.selectOne("selectUserByLogInfo", loginfo);
        }catch (Exception e) {e.printStackTrace();}
        return result;
    }

    @Override
    public List<Address> getAddressesByUserId(String userId) {
        List<Address> addresses;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            addresses = sqlSession.selectList("selectAddressesByUserId", userId);
        }
        return addresses;
    }

    @Override
    public boolean addAddress(Address address) {
        int rowsAffected;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            rowsAffected = sqlSession.insert("insertAddress", address);
            sqlSession.commit();
        }
        return rowsAffected > 0;
    }

    @Override
    public boolean addCoupons(UserCoupon userCoupon){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 首先检查优惠券记录是否存在
            Integer count = sqlSession.selectOne("selectCouponCount", userCoupon);

            int affectedRows;
            if (count != null && count > 0) {
                // 如果优惠券记录存在，更新其数量
                affectedRows = sqlSession.update("updateAddCoupons", userCoupon);
            } else {
                // 如果优惠券记录不存在，插入一条新记录
                affectedRows = sqlSession.insert("insertCoupon", userCoupon);
            }
            sqlSession.commit();
            return affectedRows > 0;
        }
    }

    @Override
    public boolean removeCoupons(UserCoupon userCoupon){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // 查询当前用户的优惠券数量
            Integer currentNum = sqlSession.selectOne("selectCouponCount", userCoupon);

            if (currentNum != null && currentNum >= userCoupon.getNum()) {
                // 用户有足够的优惠券，可以进行减少操作
                int affectedRows = sqlSession.update("updateRemoveCoupons", userCoupon);
                sqlSession.commit();
                return affectedRows > 0;
            } else {
                // 用户优惠券数量不足
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<UserCoupon> getUserCoupons(String userid){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("selectUserCoupons", userid);
        }
    }
}
