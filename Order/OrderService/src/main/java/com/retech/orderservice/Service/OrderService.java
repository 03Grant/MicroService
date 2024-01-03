package com.retech.orderservice.Service;

import com.retech.orderservice.Model.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public interface OrderService {

//    boolean createOrder(Order order);

    orderinfo getOrderById(String orderid);
//
//    boolean updateOrder(Order order);

    public String updateOrderStatus(String orderId, String newStatus, Timestamp time);

//    boolean changeOrderStatus(Order orderStatusUpdate);

    List<orderinfo> getallOrders();

    boolean insertOrderInfo(orderinfo orderInfo);

    boolean insertOrderGoods(ordergoods orderGoods);

    boolean insertOrderOffer(orderoffer orderOffer);

    boolean deleteOrderInfo(String orderid);

    boolean deleteOrderGoods(String orderid);

    boolean deleteOrderOffer(String orderid);
}
