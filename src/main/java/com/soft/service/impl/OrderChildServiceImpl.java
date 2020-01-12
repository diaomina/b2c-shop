package com.soft.service.impl;

import com.soft.mapper.OrderChildMapper;
import com.soft.model.OrderChild;
import com.soft.model.OrderChildExample;
import com.soft.service.OrderChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderChildServiceImpl
 * @Description TODO
 * @Author ljy
 * @Date 2020/1/11 23:38
 * @Version 1.0
 **/
@Service
public class OrderChildServiceImpl implements OrderChildService {

    @Autowired
    private OrderChildMapper orderChildMapper;

    /**
     * @Description 根据子订单id查询
     * @Param [orderChildId]
     * @Return com.soft.model.OrderChild
     * @Author ljy
     * @Date 2020/1/11 22:15
     */
    @Override
    public OrderChild loadByOrderChildId(Integer orderChildId) {
        return orderChildMapper.selectByPrimaryKey(orderChildId);
    }

    /**
     * @Description 根据订单号查询
     * @Param [orderNumber]
     * @Return java.util.List<com.soft.model.OrderChild>
     * @Author ljy
     * @Date 2020/1/11 22:03
     */
    @Override
    public List<OrderChild> findListByOrderNumber(String orderNumber) {
        OrderChildExample orderChildExample = new OrderChildExample();
        OrderChildExample.Criteria criteria = orderChildExample.createCriteria();
        criteria.andOrderNumberEqualTo(orderNumber);
        List<OrderChild> orderChildList = orderChildMapper.selectByExample(orderChildExample);
        if (orderChildList != null && orderChildList.size() > 0) {
            return orderChildList;
        }
        return null;
    }

    /**
     * @Description 根据订单号和商品id查询
     * @Param [orderNumber, goodsId]
     * @Return com.soft.model.OrderChild
     * @Author ljy
     * @Date 2020/1/11 22:08
     */
    @Override
    public OrderChild loadByOrderNumberAndGoodsId(String orderNumber, Integer goodsId) {
        OrderChildExample orderChildExample = new OrderChildExample();
        OrderChildExample.Criteria criteria = orderChildExample.createCriteria();
        criteria.andOrderNumberEqualTo(orderNumber);
        criteria.andGoodsIdEqualTo(goodsId);
        List<OrderChild> orderChildList = orderChildMapper.selectByExample(orderChildExample);
        if (orderChildList != null && orderChildList.size() > 0) {
            return orderChildList.get(0);
        }
        return null;
    }

    /**
     * @Description 创建子订单
     * @Param [orderChild]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 22:13
     */
    @Override
    public int createOrderChild(OrderChild orderChild) {
        return orderChildMapper.insertSelective(orderChild);
    }

    /**
     * @Description 删除子订单
     * @Param [orderChildId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 22:12
     */
    @Override
    public int delOrderChild(Integer orderChildId) {
        return orderChildMapper.deleteByPrimaryKey(orderChildId);
    }

    /**
     * @param orderChild
     * @Description 更新子订单
     * @Param [orderChild]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 22:12
     */
    @Override
    public int updateOrderChild(OrderChild orderChild) {
        return orderChildMapper.updateByPrimaryKeySelective(orderChild);
    }
}
