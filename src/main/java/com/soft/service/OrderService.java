package com.soft.service;

import com.soft.common.vo.OrderVO;
import com.soft.model.Order;

import java.util.List;

/**
 * @Description 订单的业务接口
 * @Author ljy
 * @Date 2020/1/11 20:49
 **/
public interface OrderService {

    /**
     * @Description 查询所有订单
     * @Param []
     * @Return java.util.List<com.soft.model.Order>
     * @Author ljy
     * @Date 2020/1/11 20:50
     **/
    List<Order> findAllList();

    /**
     * @Description 根据 user_id 查询订单
     * @Param [userId]
     * @Return java.util.List<com.soft.model.Order>
     * @Author ljy
     * @Date 2020/2/7 13:05
     **/
    List<Order> findListByUserId(Integer userId);

    /**
     * @Description 根据 order_id 查询订单
     * @Param [orderId]
     * @Return com.soft.model.Order
     * @Author ljy
     * @Date 2020/1/11 20:50
     **/
    Order loadByOrderId(Integer orderId);

    /**
     * @Description 创建订单
     * @Param [order]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 20:51
     **/
    int createOrder(Order order);

    /**
     * @Description 删除订单
     * @Param [orderId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 20:52
     **/
    int delOrder(Integer orderId);

    /**
     * @Description 更新订单
     * @Param [order]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 20:53
     **/
    int updateOrder(Order order);


}
