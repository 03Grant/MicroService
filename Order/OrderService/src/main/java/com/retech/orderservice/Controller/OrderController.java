package com.retech.orderservice.Controller;

import com.retech.orderservice.Model.*;
import com.retech.orderservice.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        distributeAndInsert(order);
        return ResponseEntity.ok("Order created successfully");
    }

    @GetMapping("/getinfo/{orderId}")
    public orderinfo getOrderById(@PathVariable String orderId) {
        return orderService.getOrderById(orderId);
    }

//    @PutMapping("/update")
//    public ResponseEntity<String> updateOrder(@RequestBody orderinfo order) {
//        orderService.updateOrder(order);
//        // Additional response handling if needed
//    }

    @PutMapping("/update")
    public ResponseEntity<String> updateOrder(@RequestBody orderinfo update)  {

        String orderid = update.getorderid();
        String status = update.getStatus();
        Timestamp time = update.getTime();
        String updatedStatus = orderService.updateOrderStatus(orderid, status,time);

        if (updatedStatus != null) {
            return ResponseEntity.ok("Order updated successfully. New status: " + updatedStatus);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update order");
        }
    }

//    @PutMapping("/change-status")
//    public void changeOrderStatus(@RequestBody orderinfo orderStatusUpdate) {
//        orderService.changeOrderStatus(orderStatusUpdate);
//
//        // Additional response handling if needed
//    }


    @DeleteMapping("/deleteInfo/{orderId}")
    public ResponseEntity<String> deleteOrderInfo(@PathVariable String orderId) {
        boolean deleted = orderService.deleteOrderInfo(orderId);
        if (deleted) {
            return ResponseEntity.ok("OrderInfo deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete OrderInfo");
        }
        // Additional response handling if needed
    }

    @DeleteMapping("/deleteGoods/{orderId}")
    public ResponseEntity<String> deleteOrderGoods(@PathVariable String orderId) {
        boolean deleted = orderService.deleteOrderGoods(orderId);
        if (deleted) {
            return ResponseEntity.ok("OrderGoods deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete OrderGoods");
        }
        // Additional response handling if needed
    }

    @DeleteMapping("/deleteOffer/{orderId}")
    public ResponseEntity<String> deleteOrderOffer(@PathVariable String orderId) {
        boolean deleted = orderService.deleteOrderOffer(orderId);
        if (deleted) {
            return ResponseEntity.ok("OrderOffer deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete OrderOffer");
        }
        // Additional response handling if needed
    }

//    @PutMapping("/pay")
//    public void payOrder(@RequestBody PaymentDetails paymentDetails) {
//        orderService.payOrder(paymentDetails);
//        // Additional response handling if needed
//    }



    private void distributeAndInsert(Order order) {
        // Extract values from the Order object
        String orderId = order.getOrderid();
        String userId = order.getUserid();
        Timestamp time = order.getTime();
        String status = order.getStatus();
        String couponId = order.getCouponid();
        double totAmount = order.getTot_amount();
        double couponAmount = order.getCoupon_amount();
        int commodityNum = order.getCommoditynum();
        String commodityid = order.getCommodityid();

        // Insert into orderinfo
        orderinfo orderInfo = new orderinfo(orderId, userId, time, status, totAmount);
        boolean orderInfoInserted = orderService.insertOrderInfo(orderInfo);
        System.out.println(orderInfoInserted);
        // Check if insert into orderinfo was successful before proceeding
        if (orderInfoInserted) {
            // Insert into ordergoods
            ordergoods orderGoods = new ordergoods(orderId, commodityid, commodityNum);
            orderService.insertOrderGoods(orderGoods);

            // Insert into orderoffer
            orderoffer orderOffer = new orderoffer(orderId, couponId, couponAmount);
            orderService.insertOrderOffer(orderOffer);
            //订单创建成功

            //调用库存接口更新余货
        }
    }
}
