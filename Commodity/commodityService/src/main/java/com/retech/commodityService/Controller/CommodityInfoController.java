package com.retech.commodityService.Controller;

import com.retech.commodityService.DTO.CommodityDetails;
import com.retech.commodityService.Service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commodity")
public class CommodityInfoController {

    private final CommodityService commodityService;

    @Autowired
    public CommodityInfoController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping("/{commodityid}")
    public ResponseEntity<?> getCommodityDetails(@PathVariable String commodityId) {
        CommodityDetails commodityDetails = commodityService.getCommodityDetails(commodityId);

        if (commodityDetails != null) {
            // Return CommodityDetails in the response
            return ResponseEntity.ok(commodityDetails);
        } else {
            // Commodity not found
            return ResponseEntity.status(404).body("Commodity not found");
        }
    }


}