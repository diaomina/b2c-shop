package com.soft.service.impl;

import com.soft.mapper.GoodsMapper;
import com.soft.model.Goods;
import com.soft.model.GoodsExample;
import com.soft.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName GoodsServiceImpl
 * @Description GoodsService的实现类
 * @Author ljy
 * @Date 2020/1/11 20:40
 * @Version 1.0
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * @Description 查询所有商品
     * @Param []
     * @Return java.util.List<com.soft.model.Goods>
     * @Author ljy
     * @Date 2020/1/11 20:35
     **/
    @Override
    public List<Goods> findAllListGoods() {
        return goodsMapper.selectByExample(null);
    }

    /**
     * @Description 根据 goods_name 模糊查询商品
     * @Param [goodsName]
     * @Return java.util.List<com.soft.model.Goods>
     * @Author ljy
     * @Date 2020/1/11 20:37
     */
    @Override
    public List<Goods> findListByGoodsName(String goodsName) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andGoodsNameLike("%"+goodsName+"%");
        return goodsMapper.selectByExample(goodsExample);
    }

    /**
     * @Description 根据 非顶层种类id 查询商品
     * @Param [categoryId]
     * @Return java.util.List<com.soft.model.Goods>
     * @Author ljy
     * @Date 2020/1/28 22:16
     */
    @Override
    public List<Goods> findListByCategoryId(Integer categoryId) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        return goodsMapper.selectByExample(goodsExample);
    }


    /**
     * @Description 根据 goods_id 查询商品
     * @Param [gooodsId]
     * @Return com.soft.model.Goods
     * @Author ljy
     * @Date 2020/1/11 20:35
     */
    @Override
    public Goods loadByGoodsId(Integer goodsId) {
        return goodsMapper.selectByPrimaryKey(goodsId);
    }

    /**
     * @Description 添加商品
     * @Param [goods]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 20:39
     */
    @Override
    public int createGoods(Goods goods) {
        return goodsMapper.insertSelective(goods);
    }

    /**
     * @Description 删除商品
     * @Param [goodsId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 20:39
     */
    @Override
    public int delGoods(Integer goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        goods.setDelState((byte) 1);
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    /**
     * @Description 更新商品
     * @Param [goods]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 20:40
     */
    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    /**
     * @Description 商品-批量下架
     * @Param [list]
     * @Return int
     * @Author ljy
     * @Date 2020/1/27 19:49
     */
    @Override
    public int stopBatchGoods(List<Integer> list) {
        return goodsMapper.stopBatchByPrimaryKey(list);
    }
}
