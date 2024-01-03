package com.retech.commodityService.Controller;

import com.retech.commodityService.DTO.CommodityDetails;
import com.retech.commodityService.DTO.QuantityDTO;
import com.retech.commodityService.Service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/commodity")
public class CommodityInfoController {

    private final CommodityService commodityService;

    @Autowired
    public CommodityInfoController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping("/{commodityid}")
    public ResponseEntity<?> getCommodityDetails(@PathVariable String commodityid) {

        // Specify the URL with the commodityid parameter
        String url = "http://47.97.117.9:7999/InventoryService/inventory/query?commodityid=" + commodityid;

        // Use RestTemplate to make the HTTP request and retrieve the data
        RestTemplate restTemplate = new RestTemplate();
        QuantityDTO[] response = restTemplate.getForObject(url, QuantityDTO[].class);

        // Check if the response is not null and contains at least one element
        if (response != null && response.length > 0) {
            // Get the first element from the response
            QuantityDTO x = response[0];

            // Now you can use x in your code
            CommodityDetails commodityDetails = commodityService.getCommodityDetails(commodityid);
            commodityDetails.setQuantity(x.getQuantity());

            // Return CommodityDetails in the response
            return ResponseEntity.ok(commodityDetails);
        } else {
            // Commodity not found
            return ResponseEntity.status(404).body("Commodity not found");
        }
    }
}
