package com.soft.action.admin;

import com.alibaba.fastjson.JSONObject;
import com.soft.common.vo.GoodsCategoryVO;
import com.soft.model.Admin;
import com.soft.model.GoodsCategory;
import com.soft.model.User;
import com.soft.service.AdminService;
import com.soft.service.GoodsCategoryService;
import com.soft.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName 商品种类管理
 * @Description TODO
 * @Author ljy
 * @Date 2020/1/15 19:36
 * @Version 1.0
 **/
@Controller
@RequestMapping("/goodsCategoryManager")
public class GoodsCategoryManager {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private AdminService adminService;


    /**
     * @Description 跳转到商品类型管理界面
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/15 19:42
     **/
    @RequestMapping("/goGoodsCategoryMain")
    public ModelAndView goGoodsCategoryMain(){
        List<GoodsCategoryVO> goodsCategoryVOList = new ArrayList<GoodsCategoryVO>();
        List<GoodsCategory> goodsCategoryList = goodsCategoryService.findAllListGoodsCategory();
        for (GoodsCategory goodsCategory : goodsCategoryList){
            GoodsCategoryVO goodsCategoryVO = new GoodsCategoryVO();
            goodsCategoryVO.setCategoryId(goodsCategory.getCategoryId());
            GoodsCategory g = goodsCategoryService.loadByCategoryId(goodsCategory.getParentId());
            if(g == null){
                goodsCategoryVO.setParentCategoryName("顶层种类");
            } else {
                goodsCategoryVO.setParentCategoryName(g.getCategoryName());
            }
            goodsCategoryVO.setCategoryName(goodsCategory.getCategoryName());
            goodsCategoryVO.setState(goodsCategory.getState());
            goodsCategoryVO.setCreateTime(goodsCategory.getCreateTime());
            goodsCategoryVO.setUpdateTime(goodsCategory.getUpdateTime());
            goodsCategoryVO.setSimpleDescribe(goodsCategory.getSimpleDescribe());
            goodsCategoryVO.setAdminName(adminService.loadByAdminId(goodsCategory.getAdminId()).getAdminName());
            goodsCategoryVOList.add(goodsCategoryVO);
        }
        return new ModelAndView("admin/goods_category_manager/goods_category_main", "goodsCategoryVOList", goodsCategoryVOList);
    }

    /**
     * @Description 添加种类
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/15 21:51
     **/
    @RequestMapping("/goGoodsCategoryAdd")
    public ModelAndView goGoodsCategoryAdd(){
        return new ModelAndView("admin/goods_category_manager/goods_category_add", "goodsCategoryList", goodsCategoryService.findAllListGoodsCategory());
    }


    @RequestMapping("/doGoodsCategoryAdd")
    @ResponseBody
    public JSONObject doGoodsCategoryAdd(GoodsCategory goodsCategory, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        GoodsCategory dbGoodsCategory = goodsCategoryService.loadByCategoryName(goodsCategory.getCategoryName());
        // 判断种类名是否已存在
        if(dbGoodsCategory != null) {
            // 存在
            jsonObject.put("flag","exist");
        } else {
            // 不存在
            Admin admin = (Admin) session.getAttribute("admin");
            goodsCategory.setAdminId(admin.getAdminId());
            goodsCategory.setCreateTime(new Date());
            goodsCategory.setUpdateTime(new Date());
            // 判断添加是否成功
            if(goodsCategoryService.createGoodsCategory(goodsCategory) > 0) {
                jsonObject.put("flag","true");
            } else {
                jsonObject.put("flag","false");
            }
        }
        return  jsonObject;
    }

    @RequestMapping("/goGoodsMain")
    public ModelAndView goGoodsMain(){
        return new ModelAndView("admin/goods_manager/goods_main", "goodsList", goodsService.findAllListGoods());
    }

}
