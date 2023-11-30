package com.retech.commodityService.Controller;

import com.retech.commodityService.Model.Commodity;
import com.retech.commodityService.Service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commodity-list")
public class CommodityListController {

    private final CommodityService commodityService;

    @Autowired
    public CommodityListController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping
    public ResponseEntity<?> getCommodityList() {
        List<Commodity> commodityList = commodityService.getCommodityList();
        if (!commodityList.isEmpty()) {
            // 返回商品列表
            return ResponseEntity.ok(commodityList);
        } else {
            // 没有找到商品
            return ResponseEntity.status(404).body("No commodities found");
        }
    }
}
