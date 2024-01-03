package com.retech.orderservice.Controller;

import com.retech.orderservice.Model.orderinfo;
import com.retech.orderservice.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderListController {

    private final OrderService orderservice;

    @Autowired
    public OrderListController(OrderService orderService) {
        this.orderservice = orderService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<orderinfo>> getallOrders() {
        List<orderinfo> allOrders = orderservice.getallOrders();

        if (allOrders.isEmpty()) {
            // No orders found
            return ResponseEntity.status(404).body(null);
        } else {
            // Return the list of all orders
            return ResponseEntity.ok(allOrders);
        }
    }
}
