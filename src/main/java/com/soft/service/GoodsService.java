package com.soft.service;

import com.soft.model.Goods;

import java.util.List;

/**
 * @Description 商品的业务接口
 * @Param
 * @Return
 * @Author ljy
 * @Date 2020/1/11 20:33
 **/
public interface GoodsService {

    /**
     * @Description 查询所有商品
     * @Param []
     * @Return java.util.List<com.soft.model.Goods>
     * @Author ljy
     * @Date 2020/1/11 20:35
     **/
    List<Goods> findAllListGoods();

    /**
     * @Description 根据 goods_name 模糊查询商品
     * @Param [goodsName]
     * @Return java.util.List<com.soft.model.Goods>
     * @Author ljy
     * @Date 2020/1/11 20:37
     **/
    List<Goods> findListByGoodsName(String goodsName);

    /**
     * @Description 根据 goods_id 查询商品
     * @Param [gooodsId]
     * @Return com.soft.model.Goods
     * @Author ljy
     * @Date 2020/1/11 20:35
     **/
    Goods loadByGoodsId(Integer goodsId);

    /**
     * @Description 添加商品
     * @Param [goods]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 20:39
     **/
    int createGoods(Goods goods);

    /**
     * @Description 删除商品
     * @Param [goodsId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 20:39
     **/
    int delGoods(Integer goodsId);

    /**
     * @Description 更新商品
     * @Param [goods]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 20:40
     **/
    int updateGoods(Goods goods);

}
