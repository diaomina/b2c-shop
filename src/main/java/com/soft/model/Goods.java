package com.soft.model;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
    private Integer goodsId;

    private Integer categoryId;

    private String goodsName;

    private String image;

    private Integer price;

    private Integer quantity;

    private Byte delState;

    private String simpleDescribe;

    private Byte isMarketable;

    private Date createTime;

    private Date updateTime;

    private Integer adminId;

    private Long version;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Goods{");
        sb.append("goodsId=").append(goodsId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", goodsName='").append(goodsName).append('\'');
        sb.append(", image='").append(image).append('\'');
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append(", delState=").append(delState);
        sb.append(", simpleDescribe='").append(simpleDescribe).append('\'');
        sb.append(", isMarketable=").append(isMarketable);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", adminId=").append(adminId);
        sb.append('}');
        return sb.toString();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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

    public Byte getDelState() {
        return delState;
    }

    public void setDelState(Byte delState) {
        this.delState = delState;
    }

    public String getSimpleDescribe() {
        return simpleDescribe;
    }

    public void setSimpleDescribe(String simpleDescribe) {
        this.simpleDescribe = simpleDescribe == null ? null : simpleDescribe.trim();
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

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}