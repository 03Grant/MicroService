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



    @Override
    public orderinfo getOrderById(String orderId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);

            orderinfo order = orderMapper.getOrderById(orderId);

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
//    @Override
//    public boolean updateOrder(Order order) {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
//            int result = orderMapper.updateOrder(order);
//            session.commit();
//            return result > 0;
//            // Additional business logic if needed
//        } catch (Exception e) {
//            // Handle exception, log error, and perform additional error handling if needed
//            log.error("Exception occurred while updating order: {}", order, e);
//            return false;
//        }
//    }

    @Override
    public String updateOrderStatus(String orderId, String newStatus,Timestamp time) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);

            // 根据订单ID查询订单
                // 执行更新操作
                int result = orderMapper.updateOrder(orderId,newStatus,time);
                session.commit();

                if (result > 0) {
                    // 更新成功，返回新状态
                    return newStatus;
                } else {
                    // 更新失败
                    log.error("Failed to update order status. Order ID: {}", orderId);
                }
            }
        catch (Exception e) {
            // 处理异常，记录错误日志等
            log.error("Exception occurred while updating order status. Order ID: {}", orderId, e);
        }

        // 如果更新失败或发生异常，返回空字符串或其他适当的值
        return "更新失败";
    }


    @Override
    public boolean deleteOrderInfo(String orderId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
            int result = orderMapper.deleteOrderInfo(orderId);
            session.commit();
            return result > 0;
            // Additional business logic if needed
        } catch (Exception e) {
            // Handle exception, log error, and perform additional error handling if needed
            log.error("Exception occurred while deleting order info with orderId: {}", orderId, e);
            return false;
        }
    }

    @Override
    public boolean deleteOrderGoods(String orderId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
            int result = orderMapper.deleteOrderGoods(orderId);
            session.commit();
            return result > 0;
            // Additional business logic if needed
        } catch (Exception e) {
            // Handle exception, log error, and perform additional error handling if needed
            log.error("Exception occurred while deleting order goods with orderId: {}", orderId, e);
            return false;
        }
    }

    @Override
    public boolean deleteOrderOffer(String orderId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
            orderMapper.deleteOrderOffer(orderId);
            session.commit();
            return true;
            // Additional business logic if needed
        } catch (Exception e) {
            // Handle exception, log error, and perform additional error handling if needed
            log.error("Exception occurred while deleting order offer with orderId: {}", orderId, e);
            return false;
        }
    }

//    @Override
//    public boolean changeOrderStatus(orderinfo orderStatusUpdate) {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
//            int result = orderMapper.changeOrderStatus(orderStatusUpdate);
//            // Additional business logic if needed
//            session.commit();
//            return result > 0;
//        } catch (Exception e) {
//            // Handle exception, log error, and perform additional error handling if needed
//            log.error("Exception occurred while changing order status: {}", orderStatusUpdate, e);
//            return false;
//        }
//    }

    @Override
    public List<orderinfo> getallOrders() {
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
            String orderid = orderInfo.getorderid();
            String userid = orderInfo.getUserid();
            double total_amount = orderInfo.getTotal_amount();
            String status = orderInfo.getStatus();
            Date time = orderInfo.getTime();

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
