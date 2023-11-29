package com.retech.userService.Service.impl;

import com.retech.userService.DTO.LogInfo;
import com.retech.userService.Model.User;
import com.retech.userService.Service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class UserServiceImpl implements UserService{
    //导入配置文件
    String config = "userDBconfig.xml";
    //将配置文件转换成stream
    InputStream inputStream = Resources.getResourceAsStream(config);
    //这是必需要添加的东西，现在不太清楚为什么，有待后面了解
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
}
