package com.soft.common.vo;

import com.soft.model.GoodsCategory;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName CategoryVO
 * @Description 用于商城首页商品种类展示
 * @Author ljy
 * @Date 2020/1/28 14:10
 * @Version 1.0
 **/
public class CategoryVO implements Serializable {

    // 父种类名称
    String parentCategoryName;

    // 子种类
    List<GoodsCategory> categoryList;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CategoryVO{");
        sb.append("parentCategoryName='").append(parentCategoryName).append('\'');
        sb.append(", categoryList=").append(categoryList);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryVO that = (CategoryVO) o;
        return Objects.equals(parentCategoryName, that.parentCategoryName) &&
                Objects.equals(categoryList, that.categoryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentCategoryName, categoryList);
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }

    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
    }

    public List<GoodsCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<GoodsCategory> categoryList) {
        this.categoryList = categoryList;
    }
}
