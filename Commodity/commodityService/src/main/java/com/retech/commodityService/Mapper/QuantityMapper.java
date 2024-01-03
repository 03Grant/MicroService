package com.retech.commodityService.Mapper;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QuantityMapper {
    int getQuantityByCommodityId(@Param("commodityId") String commodityId);
}
