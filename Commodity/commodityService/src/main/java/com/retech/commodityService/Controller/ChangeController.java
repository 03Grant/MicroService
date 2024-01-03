package com.retech.commodityService.Controller;

import com.retech.commodityService.Model.Commodity;
import com.retech.commodityService.Service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commodity")
public class ChangeController {

    private final CommodityService commodityService;

    @Autowired
    public ChangeController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @PostMapping("/add")
    public String addCommodity(@RequestBody Commodity commodity) {
        try {
            commodityService.addCommodity(commodity);
            return "Commodity added successfully!";
        } catch (Exception e) {
            return "Failed to add commodity. Error: " + e.getMessage();
        }
    }

    @PutMapping("/update")
    public String updateCommodity(@RequestBody Commodity commodity) {
        try {
            commodityService.updateCommodity(commodity);
            return "Commodity updated successfully!";
        } catch (Exception e) {
            return "Failed to update commodity. Error: " + e.getMessage();
        }
    }

    @DeleteMapping("/delete/{commodityId}")
    public String deleteCommodity(@PathVariable String commodityId) {
        try {
            commodityService.deleteCommodity(commodityId);
            return "Commodity deleted successfully!";
        } catch (Exception e) {
            return "Failed to delete commodity. Error: " + e.getMessage();
        }
    }
}
