package com.soft.service;

import com.soft.model.Cart;

import java.util.List;

/**
 * @Description 购物车的业务接口
 * @Author ljy
 * @Date 2020/1/11 19:44
 **/
public interface CartService {

    /**
     * @Description 根据 user_id 查询购物车
     * @Param [userId]
     * @Return java.util.List<com.soft.model.Cart>
     * @Author ljy
     * @Date 2020/1/11 19:45
     **/
    List<Cart> findListByUserId(Integer userId);

    /**
     * @Description 根据购物车id查询
     * @Param [cartId]
     * @Return com.soft.model.Cart
     * @Author ljy
     * @Date 2020/2/3 18:00
     **/
    Cart loadByCartId(Integer cartId);

    /**
     * @Description 添加购物车
     * @Param [cart]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:46
     **/
    int createCart(Cart cart);

    /**
     * @Description 删除购物车
     * @Param [cartId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:47
     **/
    int delCart(Integer cartId);

    /**
     * @Description 更新购物车
     * @Param [cart]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:47
     **/
    int updateCart(Cart cart);

}
