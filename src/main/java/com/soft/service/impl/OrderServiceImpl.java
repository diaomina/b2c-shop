package com.soft.service.impl;

import com.soft.common.vo.OrderVO;
import com.soft.mapper.OrderMapper;
import com.soft.model.Order;
import com.soft.model.OrderExample;
import com.soft.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description OrderService实现类
 * @Author ljy
 * @Date 2020/1/28 13:43
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * @Description 查询所有订单
     * @Param []
     * @Return java.util.List<com.soft.model.Order>
     * @Author ljy
     * @Date 2020/1/11 20:50
     **/
    @Override
    public List<Order> findAllList() {
        return orderMapper.selectByExample(null);
    }

    /**
     * @Description 根据 user_id 查询订单
     * @Param [userId]
     * @Return java.util.List<com.soft.model.Order>
     * @Author ljy
     * @Date 2020/2/7 13:05
     */
    @Override
    public List<Order> findListByUserId(Integer userId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return orderMapper.selectByExample(orderExample);
    }

    /**
     * @Description 根据 order_id 查询订单
     * @Param [orderId]
     * @Return com.soft.model.Order
     * @Author ljy
     * @Date 2020/1/11 20:50
     */
    @Override
    public Order loadByOrderId(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    /**
     * @Description 根据订单号查询订单
     * @Param [orderNumber]
     * @Return com.soft.model.Order
     * @Author ljy
     * @Date 2020/2/14 0:23
     */
    @Override
    public Order loadByOrderNumber(String orderNumber) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderNumberEqualTo(orderNumber);
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        if(orderList != null && orderList.size() > 0){
            return orderList.get(0);
        }
        return null;
    }

    /**
     * @Description 创建订单
     * @Param [order]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 20:51
     */
    @Override
    public int createOrder(Order order) {
        return orderMapper.insertSelective(order);
    }

    /**
     * @Description 删除订单
     * @Param [orderId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 20:52
     */
    @Override
    public int delOrder(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    /**
     * @Description 更新订单
     * @Param [order]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 20:53
     */
    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    /**
     * @Description 订单-批量删除
     * @Param [list]
     * @Return int
     * @Author ljy
     * @Date 2020/2/11 16:59
     */
    @Override
    public int delBatchOrder(List<Integer> list) {
        return orderMapper.delBatchByPrimaryKey(list);
    }


}
