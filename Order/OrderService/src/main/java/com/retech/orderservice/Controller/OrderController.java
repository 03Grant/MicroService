package com.retech.orderservice.Controller;

import com.retech.orderservice.Model.*;
import com.retech.orderservice.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody Order order) {
        distributeAndInsert(order);
        // Additional response handling if needed
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable String orderId) {
        return orderService.getOrderById(orderId);
    }

    @PutMapping("/update")
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
        // Additional response handling if needed
    }

    @DeleteMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
        // Additional response handling if needed
    }

//    @PutMapping("/pay")
//    public void payOrder(@RequestBody PaymentDetails paymentDetails) {
//        orderService.payOrder(paymentDetails);
//        // Additional response handling if needed
//    }

    @PutMapping("/change-status")
    public void changeOrderStatus(@RequestBody Order orderStatusUpdate) {
        orderService.changeOrderStatus(orderStatusUpdate);

        // Additional response handling if needed
    }

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

        // Insert into orderinfo
        orderinfo orderInfo = new orderinfo(orderId, userId, time, status, totAmount);
        boolean orderInfoInserted = orderService.insertOrderInfo(orderInfo);

        // Check if insert into orderinfo was successful before proceeding
        if (orderInfoInserted) {
            // Insert into ordergoods
            ordergoods orderGoods = new ordergoods(orderId, order.getCommodityid(), commodityNum);
            orderService.insertOrderGoods(orderGoods);

            // Insert into orderoffer
            orderoffer orderOffer = new orderoffer(orderId, couponId, couponAmount);
            orderService.insertOrderOffer(orderOffer);
            //订单创建成功

            //调用库存接口更新余货
        }
    }
}
