package com.soft.service.impl;

import com.soft.mapper.CartMapper;
import com.soft.model.Cart;
import com.soft.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CartServiceImpl
 * @Description CartService的实现类
 * @Author ljy
 * @Date 2020/1/11 20:31
 * @Version 1.0
 **/
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    /**
     * @Description 根据 user_id 查询购物车
     * @Param [userId]
     * @Return java.util.List<com.soft.model.Cart>
     * @Author ljy
     * @Date 2020/1/11 19:45
     */
    @Override
    public List<Cart> findListByUserId(Integer userId) {
        return cartMapper.selectByExample(null);
    }

    /**
     * @param cartId
     * @Description 根据购物车id查询
     * @Param [cartId]
     * @Return com.soft.model.Cart
     * @Author ljy
     * @Date 2020/2/3 18:00
     */
    @Override
    public Cart loadByCartId(Integer cartId) {
        return cartMapper.selectByPrimaryKey(cartId);
    }

    /**
     * @Description 添加购物车
     * @Param [cart]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:46
     */
    @Override
    public int createCart(Cart cart) {
        return cartMapper.insertSelective(cart);
    }

    /**
     * @Description 删除购物车
     * @Param [cartId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:47
     */
    @Override
    public int delCart(Integer cartId) {
        return cartMapper.deleteByPrimaryKey(cartId);
    }

    /**
     * @Description 更新购物车
     * @Param [cart]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:47
     */
    @Override
    public int updateCart(Cart cart) {
        return cartMapper.updateByPrimaryKeySelective(cart);
    }
}
