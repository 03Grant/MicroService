package com.retech.commodityService.Service;

import com.retech.commodityService.DTO.CommodityDetails;
import com.retech.commodityService.Model.Commodity;
import com.retech.commodityService.DTO.CommodityInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommodityService {

    // 获取商品列表
    List<CommodityInfo> getCommodityList();
    CommodityDetails getCommodityDetails(String commodityid);

    List<CommodityInfo> searchCommodities(CommodityDetails searchCriteria);


    // 根据商品ID获取商品信息
    Commodity getCommodityByid(String commodityid);
    double getPriceByCommodityid(String commodityid);

    // 添加新商品
    boolean addCommodity(Commodity commodity);

    // 更新商品信息
    boolean updateCommodity(Commodity commodity);

    // 删除商品
    boolean deleteCommodity(String commodityId);

    // 根据参数搜索商品列表

}
