package com.retech.commodityService.Controller;

import com.retech.commodityService.DTO.CommodityInfo;
import com.retech.commodityService.Service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commodity")
public class CommodityInfoController {

    private final CommodityService commodityService;

    @Autowired
    public CommodityInfoController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping("/{commodityId}")
    public ResponseEntity<?> getCommodityDetails(@PathVariable String commodityId) {
        CommodityInfo commodityinfo = commodityService.getCommodityById(commodityId);

        if (commodityinfo != null) {
            CommodityInfo commodityInfo = new CommodityInfo();
            commodityInfo.setCommodityId(commodityinfo.getCommodityId());
            commodityInfo.setCommodityName(commodityinfo.getCommodityName());
            commodityInfo.setBrand(commodityinfo.getBrand());
            commodityInfo.setPrice(commodityinfo.getPrice());
            commodityInfo.setStock(commodityinfo.getStock());

            return ResponseEntity.ok(commodityInfo);
        } else {
            return ResponseEntity.status(404).body("Commodity not found");
        }
    }
}
