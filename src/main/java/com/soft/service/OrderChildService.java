package com.soft.service;

import com.soft.model.OrderChild;

import java.util.List;

/**
 * @Description 子订单的业务接口
 * @Author ljy
 * @Date 2020/1/11 22:02
 **/
public interface OrderChildService {

    /**
     * @Description 根据子订单id查询
     * @Param [orderChildId]
     * @Return com.soft.model.OrderChild
     * @Author ljy
     * @Date 2020/1/11 22:15
     **/
    OrderChild loadByOrderChildId(Integer orderChildId);

    /**
     * @Description 根据订单号查询
     * @Param [orderNumber]
     * @Return java.util.List<com.soft.model.OrderChild>
     * @Author ljy
     * @Date 2020/1/11 22:03
     **/
    List<OrderChild> findListByOrderNumber(String orderNumber);

    /**
     * @Description 根据订单号和商品id查询
     * @Param [orderNumber, goodsId]
     * @Return com.soft.model.OrderChild
     * @Author ljy
     * @Date 2020/1/11 22:08
     **/
    OrderChild loadByOrderNumberAndGoodsId(String orderNumber, Integer goodsId);

    /**
     * @Description 创建子订单
     * @Param [orderChild]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 22:13
     **/
    int createOrderChild(OrderChild orderChild);

    /**
     * @Description 删除子订单
     * @Param [orderChildId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 22:12
     **/
    int delOrderChild(Integer orderChildId);

    /**
     * @Description 更新子订单
     * @Param [orderChild]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 22:12
     **/
    int updateOrderChild(OrderChild orderChild);

}
