package com.soft.common.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName GoodsVO
 * @Description 商品的vo类
 * @Author ljy
 * @Date 2020/1/27 15:05
 * @Version 1.0
 **/
public class GoodsVO implements Serializable {

    // 商品id
    private Integer goodsId;
    // 商品名称
    private String goodsName;
    // 种类名称
    private String categoryName;
    // 商品图片
    private String image;
    // 商品单价（以分为单位）
    private Integer price;
    // 库存数量
    private Integer quantity;
    // 简要描述
    private String simpleDescribe;
    // 上架标志 1 已上架 0 未上架
    private Byte isMarketable;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
    // 创建者
    private String adminName;

    private static final long serialVersionUID = 1L;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSimpleDescribe() {
        return simpleDescribe;
    }

    public void setSimpleDescribe(String simpleDescribe) {
        this.simpleDescribe = simpleDescribe;
    }

    public Byte getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(Byte isMarketable) {
        this.isMarketable = isMarketable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
