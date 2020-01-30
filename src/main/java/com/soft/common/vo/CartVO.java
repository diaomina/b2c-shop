package com.soft.common.vo;

import com.soft.model.Goods;

import java.io.Serializable;

/**
 * @ClassName CartVO
 * @Description 用户购物车信息展示
 * @Author ljy
 * @Date 2020/1/30 19:30
 * @Version 1.0
 **/
public class CartVO implements Serializable {

    // 购物车id
    private Integer cartId;

    // 用户id
    private Integer userId;

    // 商品信息
    private com.soft.model.Goods goods;

    // 商品数量
    private Integer quantity;

    private static final long serialVersionUID = 1L;


    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
