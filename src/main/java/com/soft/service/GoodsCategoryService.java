package com.soft.service;

import com.soft.model.GoodsCategory;
import com.soft.model.User;

import java.util.List;

/**
 * @Description 商品种类的业务接口
 * @Author ljy
 * @Date 2020/1/11 19:09
 **/
public interface GoodsCategoryService {

    /**
     * @Description 查询所有商品种类
     * @Param []
     * @Return java.util.List<com.soft.model.GoodsCategory>
     * @Author ljy
     * @Date 2020/1/11 19:11
     **/
    List<GoodsCategory> findAllListGoodsCategory();

    /**
     * @Description 根据 category_id 查找商品种类
     * @Param [categoryId]
     * @Return com.soft.model.GoodsCategory
     * @Author ljy
     * @Date 2020/1/11 19:12
     **/
    GoodsCategory loadByCategoryId(Integer categoryId);

    /**
     * @Description 根据商品种类名称查找
     * @Param [categoryName]
     * @Return com.soft.model.GoodsCategory
     * @Author ljy
     * @Date 2020/1/15 22:07
     **/
    GoodsCategory loadByCategoryName(String categoryName);

    /**
     * @Description 添加商品种类
     * @Param [goodsCategory]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:14
     **/
    int createGoodsCategory(GoodsCategory goodsCategory);

    /**
     * @Description 删除商品种类
     * @Param [categoryId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:14
     **/
    int delGoodsCategory(Integer categoryId);

    /**
     * @Description 更新商品种类
     * @Param [goodsCategory]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:15
     **/
    int updateGoodsCategory(GoodsCategory goodsCategory);

}
