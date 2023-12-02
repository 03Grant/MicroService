package com.retech.commodityService.Service.impl;

import com.retech.commodityService.DTO.CommodityDetails;
import com.retech.commodityService.Model.Commodity;
import com.retech.commodityService.DTO.CommodityInfo;
import com.retech.commodityService.Model.Price;
import com.retech.commodityService.Mapper.CommodityMapper;
import com.retech.commodityService.Service.CommodityService;
import jakarta.annotation.Resource;
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
public class CommodityServiceImpl implements CommodityService {

    // 加载Mybatis核心配置文件，获取 SqlSessionFactory
    String config = "commodityDBconfig.xml";
    InputStream inputStream = Resources.getResourceAsStream(config);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    // 获取SqlSession对象，用来执行sql语句
    SqlSession sqlSession = sqlSessionFactory.openSession();

    CommodityMapper commodityMapper = sqlSession.getMapper(CommodityMapper.class);
    // 执行sql
    @Override
    public List<CommodityInfo> getCommodityList() {
        return commodityMapper.getAllCommodityInfo();
    }

    @Override
    public CommodityDetails getCommodityDetails(String commodityid) {
        return commodityMapper.getCommodityDetails(commodityid);
    }

    @Override
    public List<CommodityInfo> searchCommodities(CommodityDetails searchCriteria) {
        return commodityMapper.searchCommodities(searchCriteria);
    }

    @Override
    public Commodity getCommodityByid(String commodityid) {
        return null;
    }


    @Autowired
    public CommodityServiceImpl(CommodityMapper commodityMapper) throws IOException {
        this.commodityMapper = commodityMapper;
    }

    @Override
    public double getPriceByCommodityid(String commodityid){
        return commodityMapper.getPriceByCommodityid(commodityid);
    }
    @Override
    public boolean addCommodity(Commodity commodity) {
        int rowsAffected = commodityMapper.insertCommodity(commodity);
        return rowsAffected > 0;
    }

    @Override
    public boolean updateCommodity(Commodity commodity) {
        int rowsAffected = commodityMapper.updateCommodity(commodity);
        return rowsAffected > 0;
    }

    @Override
    public boolean deleteCommodity(String commodityid) {
        int rowsAffected = commodityMapper.deleteCommodity(commodityid);
        return rowsAffected > 0;
    }


}
