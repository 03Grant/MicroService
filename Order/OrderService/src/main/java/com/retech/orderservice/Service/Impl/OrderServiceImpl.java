package com.retech.orderservice.Service.Impl;

import com.retech.orderservice.Service.OrderService;
import com.retech.orderservice.Model.*;
import com.retech.orderservice.Mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class OrderServiceImpl implements OrderService {

    private final SqlSessionFactory sqlSessionFactory;

    @Autowired
    public OrderServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);


//    @Override
//    public boolean createOrder(Order order) {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//
//            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
//            int result = orderMapper.createOrder(order);
//            if (result > 0) {
//                // 订单成功创建，可以执行其他操作，例如更新库存等
//                // 提交事务
//                session.commit();
//                return true;
//            } else {
//                log.error("Failed to create order. Order details: {}", order);
//
////                // 抛出自定义异常
////                throw new OrderCreationException("Failed to create order");
//                // 回滚事务
//                session.rollback();
//                return false;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//    }

    @Override
    public Order getOrderById(String orderId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);

            Order order = orderMapper.getOrderById(orderId);

            if (order != null) {
                // 订单成功检索，可以执行其他操作，例如日志记录
                return order;
            } else {
                // 订单未找到，记录警告日志
                log.warn("Order not found for orderId: {}", orderId);
                return null;
            }

        } catch (Exception e) {
            // 处理异常，记录错误日志
            log.error("Exception occurred while retrieving order by orderId: {}", orderId, e);

            // 可以抛出自定义异常，也可以返回 null 或进行其他处理
            return null;
        }
    }
    @Override
    public boolean updateOrder(Order order) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
            int result = orderMapper.updateOrder(order);
            session.commit();
            return result > 0;
            // Additional business logic if needed
        } catch (Exception e) {
            // Handle exception, log error, and perform additional error handling if needed
            log.error("Exception occurred while updating order: {}", order, e);
            return false;
        }
    }

    @Override
    public boolean deleteOrder(String orderId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
            int result = orderMapper.deleteOrder(orderId);
            session.commit();
            return result > 0;
            // Additional business logic if needed
        } catch (Exception e) {
            // Handle exception, log error, and perform additional error handling if needed
            log.error("Exception occurred while deleting order with orderId: {}", orderId, e);
            return false;
        }
    }

    @Override
    public boolean changeOrderStatus(Order orderStatusUpdate) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
            int result = orderMapper.changeOrderStatus(orderStatusUpdate);
            // Additional business logic if needed
            session.commit();
            return result > 0;
        } catch (Exception e) {
            // Handle exception, log error, and perform additional error handling if needed
            log.error("Exception occurred while changing order status: {}", orderStatusUpdate, e);
            return false;
        }
    }

    @Override
    public List<Order> getallOrders() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);

            return orderMapper.getallOrders();
        } catch (Exception e) {
            // Handle exception, log error, and perform additional error handling if needed
            log.error("Exception occurred while retrieving all orders", e);
            return null;
        }
    }

    @Override
    public boolean insertOrderInfo(orderinfo orderInfo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
            // 提取orderInfo的值
            String orderid = orderInfo.getOrderid();
            String userid = orderInfo.getUserid();
            double total_amount = orderInfo.getTotal_amount();
            String status = orderInfo.getStatus();
            Date time = orderInfo.getTime();

//            // 将Timestamp转换为LocalDateTime
//            LocalDateTime localDateTime = time.toLocalDateTime();
//
//            // 使用DateTimeFormatter格式化日期
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            String formattedTime = localDateTime.format(formatter);

            // 调用insertOrderInfo函数并传递提取的值
            System.out.println("orderid: " + orderid + ", userid: " + userid + ", total_amount: " + total_amount + ", status: " + status + ", time: " + time);

            int result = orderMapper.insertOrderInfo(orderid, userid, total_amount, status, time);
            System.out.println("arrive");
            session.commit();
            return result > 0;
        } catch (Exception e) {
            log.error("Exception occurred while inserting orderInfo: {}", orderInfo, e);
            return false;
        }
    }

    @Override
    public boolean insertOrderGoods(ordergoods orderGoods) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
            int result = orderMapper.insertOrderGoods(orderGoods);

            session.commit();
            return result > 0;
        } catch (Exception e) {
            log.error("Exception occurred while inserting orderGoods: {}", orderGoods, e);
            return false;
        }
    }

    @Override
    public boolean insertOrderOffer(orderoffer orderOffer) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
            int result = orderMapper.insertOrderOffer(orderOffer);
            session.commit();
            return result > 0;
        } catch (Exception e) {
            log.error("Exception occurred while inserting orderOffer: {}", orderOffer, e);
            return false;
        }
    }

}
