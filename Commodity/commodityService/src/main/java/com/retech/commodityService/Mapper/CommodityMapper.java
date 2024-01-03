package com.retech.commodityService.Mapper;

import com.retech.commodityService.DTO.CommodityDetails;
import com.retech.commodityService.DTO.CommodityInfo;
import com.retech.commodityService.Model.Commodity;
import com.retech.commodityService.Model.Price;

import java.util.List;

public interface CommodityMapper {


    int insertCommodity(Commodity commodity);
    int updateCommodity(Commodity commodity);
    int deleteCommodity(String commodityid);
//    List<Commodity> selectAll();
    List<CommodityInfo> getAllCommodityInfo();
    CommodityDetails getCommodityDetails(String commodityid);

    List<CommodityInfo> searchCommodities(CommodityDetails searchCriteria);





    List<Commodity> findCommodityByname(String commodityid);
    double getPriceByCommodityid(String commodityid);
}
