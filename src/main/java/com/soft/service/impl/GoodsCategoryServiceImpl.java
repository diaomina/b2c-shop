package com.soft.service.impl;

import com.soft.mapper.GoodsCategoryMapper;
import com.soft.model.GoodsCategory;
import com.soft.model.GoodsCategoryExample;
import com.soft.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GoodsCategoryServiceImpl
 * @Description TODO
 * @Author ljy
 * @Date 2020/1/11 19:29
 * @Version 1.0
 **/
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    /**
     * @Description 查询所有商品种类
     * @Param []
     * @Return java.util.List<com.soft.model.GoodsCategory>
     * @Author ljy
     * @Date 2020/1/11 19:11
     **/
    @Override
    public List<GoodsCategory> findAllListGoodsCategory() {
        return goodsCategoryMapper.selectByExample(null);
    }

    /**
     * @Description 根据父种类id查询其子种类
     * @Param []
     * @Return java.util.List<com.soft.model.GoodsCategory>
     * @Author ljy
     * @Date 2020/2/13 0:39
     */
    @Override
    public List<GoodsCategory> findListGoodsCategoryByParentId(Integer parentId) {
        GoodsCategoryExample goodsCategoryExample = new GoodsCategoryExample();
        GoodsCategoryExample.Criteria criteria = goodsCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        return goodsCategoryMapper.selectByExample(goodsCategoryExample);
    }

    /**
     * @Description 根据 category_id 查找商品种类
     * @Param [categoryId]
     * @Return com.soft.model.GoodsCategory
     * @Author ljy
     * @Date 2020/1/11 19:12
     */
    @Override
    public GoodsCategory loadByCategoryId(Integer categoryId) {
        return goodsCategoryMapper.selectByPrimaryKey(categoryId);
    }

    /**
     * @Description 根据商品种类名称查找
     * @Param [categoryName]
     * @Return com.soft.model.GoodsCategory
     * @Author ljy
     * @Date 2020/1/15 22:07
     */
    @Override
    public GoodsCategory loadByCategoryName(String categoryName) {
        GoodsCategoryExample goodsCategoryExample = new GoodsCategoryExample();
        GoodsCategoryExample.Criteria criteria = goodsCategoryExample.createCriteria();
        criteria.andCategoryNameEqualTo(categoryName);
        List<GoodsCategory> goodsCategoryList = goodsCategoryMapper.selectByExample(goodsCategoryExample);
        if(goodsCategoryList != null && goodsCategoryList.size() > 0){
            return goodsCategoryList.get(0);
        }
        return null;
    }

    /**
     * @Description 添加商品种类
     * @Param [goodsCategory]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:14
     */
    @Override
    public int createGoodsCategory(GoodsCategory goodsCategory) {
        return goodsCategoryMapper.insertSelective(goodsCategory);
    }

    /**
     * @param categoryId
     * @Description 删除商品种类
     * @Param [categoryId]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:14
     */
    @Override
    public int delGoodsCategory(Integer categoryId) {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByPrimaryKey(categoryId);
        goodsCategory.setState((byte) 3);
        return goodsCategoryMapper.updateByPrimaryKeySelective(goodsCategory);
    }

    /**
     * @param goodsCategory
     * @Description 更新商品种类
     * @Param [goodsCategory]
     * @Return int
     * @Author ljy
     * @Date 2020/1/11 19:15
     */
    @Override
    public int updateGoodsCategory(GoodsCategory goodsCategory) {
        return goodsCategoryMapper.updateByPrimaryKeySelective(goodsCategory);
    }
}
