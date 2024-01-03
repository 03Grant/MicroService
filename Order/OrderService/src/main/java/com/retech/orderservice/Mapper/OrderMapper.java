package com.retech.orderservice.Mapper;

import com.retech.orderservice.Model.Order;
import com.retech.orderservice.Model.ordergoods;
import com.retech.orderservice.Model.orderinfo;
import com.retech.orderservice.Model.orderoffer;
import org.springframework.stereotype.Service;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

import java.sql.Timestamp;
import java.util.List;

public interface OrderMapper {

    // 创建订单
    int createOrder(Order order);

    // 查询订单
    Order getOrderById(String orderId);

    // 更新订单
    int updateOrder(Order order);

    // 删除订单
    int deleteOrder(String orderId);

    // 更改订单状态
    int changeOrderStatus(Order orderStatusUpdate);

    // 获取所有订单
    List<Order> getallOrders();

    int insertOrderInfo(@Param("orderid") String orderid,
                        @Param("userid") String userid,
                        @Param("total_amount") double total_amount,
                        @Param("status") String status,
                        @Param("time") Date time);


    int insertOrderGoods(ordergoods orderGoods);

    int insertOrderOffer(orderoffer orderOffer);
}
