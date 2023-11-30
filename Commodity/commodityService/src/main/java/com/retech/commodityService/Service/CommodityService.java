package com.retech.commodityService.Service;

import com.retech.commodityService.DTO.CommodityInfo;
import com.retech.commodityService.Model.Commodity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommodityService {

    // 获取商品列表
    List<Commodity> getCommodityList();

    // 根据商品ID获取商品信息
    CommodityInfo getCommodityById(String commodityId);

    // 添加新商品
    boolean addCommodity(Commodity commodity);

    // 更新商品信息
    boolean updateCommodity(Commodity commodity);

    // 删除商品
    boolean deleteCommodity(String commodityId);
}
