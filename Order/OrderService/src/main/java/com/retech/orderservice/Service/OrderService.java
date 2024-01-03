package com.retech.orderservice.Service;

import com.retech.orderservice.Model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

//    boolean createOrder(Order order);

    Order getOrderById(String orderid);

    boolean updateOrder(Order order);

    boolean deleteOrder(String orderid);

    boolean changeOrderStatus(Order orderStatusUpdate);

    List<Order> getallOrders();

    boolean insertOrderInfo(orderinfo orderInfo);

    boolean insertOrderGoods(ordergoods orderGoods);

    boolean insertOrderOffer(orderoffer orderOffer);
}
