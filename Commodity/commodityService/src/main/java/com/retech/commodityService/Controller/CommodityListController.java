package com.retech.commodityService.Controller;

import com.retech.commodityService.DTO.CommodityDetails;
import com.retech.commodityService.DTO.CommodityInfo;
import com.retech.commodityService.Service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/commodity")
public class CommodityListController {

    private final CommodityService commodityService;

    @Autowired
    public CommodityListController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping("/list")
    public List<CommodityInfo> getCommodityList() {
        return commodityService.getCommodityList();
    }

    @GetMapping("/search")
    public ResponseEntity<List<CommodityInfo>> searchCommodities(
            @RequestParam(required = false) String commodityName,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String CPU,
            @RequestParam(required = false) String GPU,
            @RequestParam(required = false) String disk,
            @RequestParam(required = false) String memory) {

        CommodityDetails searchCriteria = new CommodityDetails();
        searchCriteria.setCommodityName(commodityName);
        searchCriteria.setBrand(brand);
        searchCriteria.setPrice(price);
        searchCriteria.setCPU(CPU);
        searchCriteria.setGPU(GPU);
        searchCriteria.setDisk(disk);
        searchCriteria.setMemory(memory);

        List<CommodityInfo> searchResults = commodityService.searchCommodities(searchCriteria);

        if (searchResults.isEmpty()) {
            // No matching commodities found
            return ResponseEntity.status(404).body(null);
        } else {
            // Return the list of matching commodities
            return ResponseEntity.ok(searchResults);
        }
    }
}
