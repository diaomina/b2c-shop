package com.soft.common.vo;

import com.soft.model.Goods;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName OrderChildVO
 * @Description 子订单显示
 * @Author ljy
 * @Date 2020/2/7 14:13
 * @Version 1.0
 **/
public class OrderChildVO implements Serializable {

    private Integer orderChildId;

    private Goods goods;

    private Integer quantity;

    private static final long serialVersionUID = 1L;

    public Integer getOrderChildId() {
        return orderChildId;
    }

    public void setOrderChildId(Integer orderChildId) {
        this.orderChildId = orderChildId;
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
