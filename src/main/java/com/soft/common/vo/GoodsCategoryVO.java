package com.soft.common.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName GoodsCategoryVO
 * @Description 用于商品种类信息展示
 * @Author ljy
 * @Date 2020/1/15 19:54
 * @Version 1.0
 **/
public class GoodsCategoryVO implements Serializable {
    // 商品种类ID
    private Integer categoryId;
    // 父种类名称
    private String parentCategoryName;
    // 商品种类名称
    private String categoryName;
    // 状态 1.启用 2.未启用 3 已删除
    private Byte state;
    // 简要描述
    private String simpleDescribe;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
    // 创建者
    private String adminName;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GoodsCategoryVO{");
        sb.append("categoryId=").append(categoryId);
        sb.append(", parentCategoryName='").append(parentCategoryName).append('\'');
        sb.append(", categoryName='").append(categoryName).append('\'');
        sb.append(", state=").append(state);
        sb.append(", simpleDescribe='").append(simpleDescribe).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", adminName='").append(adminName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }

    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getSimpleDescribe() {
        return simpleDescribe;
    }

    public void setSimpleDescribe(String simpleDescribe) {
        this.simpleDescribe = simpleDescribe;
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
