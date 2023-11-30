package com.retech.commodityService.Service.impl;

import com.retech.commodityService.Model.Commodity;
import com.retech.commodityService.Mapper.CommodityMapper;
import com.retech.commodityService.Service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    private final CommodityMapper commodityMapper;

    @Autowired
    public CommodityServiceImpl(CommodityMapper commodityMapper) {
        this.commodityMapper = commodityMapper;
    }

    @Override
    public List<Commodity> getCommodityList() {
        return commodityMapper.findAllCommodities();
    }

    @Override
    public Commodity getCommodityById(String commodityId) {
        return commodityMapper.findCommodityById(commodityId);
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
    public boolean deleteCommodity(String commodityId) {
        int rowsAffected = commodityMapper.deleteCommodity(commodityId);
        return rowsAffected > 0;
    }
}
