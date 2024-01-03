package com.retech.commodityService.Service.impl;

import com.retech.commodityService.DTO.CommodityDetails;
import com.retech.commodityService.Model.Commodity;
import com.retech.commodityService.DTO.CommodityInfo;
import com.retech.commodityService.Mapper.CommodityMapper;
import com.retech.commodityService.Mapper.QuantityMapper;
import com.retech.commodityService.Service.CommodityService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {


    private final SqlSessionFactory sqlSessionFactory;

    @Autowired
    public CommodityServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }



    @Override
    public List<CommodityInfo> getCommodityList() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CommodityMapper mapper = session.getMapper(CommodityMapper.class);
            return mapper.getAllCommodityInfo();
        } catch (Exception e) {
            // 处理异常，这里可以根据实际情况进行处理
            e.printStackTrace();
            return null;// 或者抛出异常，具体处理取决于业务需求
        }
    }
//    @Override
//    public List<CommodityInfo> getCommodityList() {
//        return commodityMapper.getAllCommodityInfo();
//    }

    @Override
    public CommodityDetails getCommodityDetails(String commodityid) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CommodityMapper mapper = session.getMapper(CommodityMapper.class);
            return mapper.getCommodityDetails(commodityid);
        } catch (Exception e) {
            // 处理异常，这里可以根据实际情况进行处理
            e.printStackTrace();
            return null; // 或者抛出异常，具体处理取决于业务需求
        }
    }

    @Override
    public List<CommodityInfo> searchCommodities(CommodityDetails searchCriteria) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CommodityMapper mapper = session.getMapper(CommodityMapper.class);
            return mapper.searchCommodities(searchCriteria);
        } catch (Exception e) {
            // 处理异常，这里可以根据实际情况进行处理
            e.printStackTrace();
            return null; // 或者抛出异常，具体处理取决于业务需求
        }
    }
    @Override
    public Commodity getCommodityByid(String commodityid) {
        // 实现你的逻辑
        return null;
    }

    @Override
    public double getPriceByCommodityid(String commodityid) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CommodityMapper mapper = session.getMapper(CommodityMapper.class);
            return mapper.getPriceByCommodityid(commodityid);
        } catch (Exception e) {
            // 处理异常，这里可以根据实际情况进行处理
            e.printStackTrace();
            return 0.0; // 或者抛出异常，具体处理取决于业务需求
        }
    }
    @Override
    public boolean addCommodity(Commodity commodity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CommodityMapper mapper = session.getMapper(CommodityMapper.class);
            int rowsAffected = mapper.insertCommodity(commodity);
            session.commit();
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，这里可以根据实际情况进行处理
            e.printStackTrace();
            return false; // 或者抛出异常，具体处理取决于业务需求
        }
    }
    @Override
    public boolean updateCommodity(Commodity commodity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CommodityMapper mapper = session.getMapper(CommodityMapper.class);
            int rowsAffected = mapper.updateCommodity(commodity);
            session.commit();
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，这里可以根据实际情况进行处理
            e.printStackTrace();
            return false; // 或者抛出异常，具体处理取决于业务需求
        }
    }

    @Override
    public boolean deleteCommodity(String commodityid) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CommodityMapper mapper = session.getMapper(CommodityMapper.class);
            int rowsAffected = mapper.deleteCommodity(commodityid);
            session.commit();
            return rowsAffected > 0;
        } catch (Exception e) {
            // 处理异常，这里可以根据实际情况进行处理
            e.printStackTrace();
            return false; // 或者抛出异常，具体处理取决于业务需求
        }
    }
    @Override
    public int getQuantityByCommodityId(String commodityId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            QuantityMapper mapper = session.getMapper(QuantityMapper.class);
            return mapper.getQuantityByCommodityId(commodityId);
        } catch (Exception e) {
            // 处理异常，这里可以根据实际情况进行处理
            e.printStackTrace();
            return 0; // 或者抛出异常，具体处理取决于业务需求
        }
    }


}