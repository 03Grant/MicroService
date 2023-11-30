package com.retech.commodityService.Mapper;

import com.retech.commodityService.Model.Commodity;

import java.util.List;

public interface CommodityMapper {
    int insertCommodity(Commodity commodity);
    int updateCommodity(Commodity commodity);
    int deleteCommodity(String commodityId);
    List<Commodity> findAllCommodities();
    Commodity findCommodityById(String commodityId);
}
