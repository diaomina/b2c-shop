package com.soft.action;

import com.alibaba.fastjson.JSONObject;
import com.soft.common.vo.GoodsCategoryVO;
import com.soft.model.Admin;
import com.soft.model.GoodsCategory;
import com.soft.service.AdminService;
import com.soft.service.GoodsCategoryService;
import com.soft.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName GoodsCategoryManager
 * @Description 商品种类管理
 * @Author ljy
 * @Date 2020/1/15 19:36
 * @Version 1.0
 **/
@Controller
@RequestMapping("/goodsCategoryAction")
public class GoodsCategoryAction {

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private AdminService adminService;


    /**
     * @Description 跳转到商品种类管理界面
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
            // 判断是否删除
            if(goodsCategory.getState() != 3) {
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
        }
        return new ModelAndView("admin/goods_category_manager/goods_category_main", "goodsCategoryVOList", goodsCategoryVOList);
    }

    /**
     * @Description 跳转到种类添加界面
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/15 21:51
     **/
    @RequestMapping("/goGoodsCategoryAdd")
    public ModelAndView goGoodsCategoryAdd(){
        return new ModelAndView("admin/goods_category_manager/goods_category_add", "goodsCategoryList", goodsCategoryService.findAllListGoodsCategory());
    }


    /**
     * @Description 种类添加
     * @Param [goodsCategory, session]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/16 18:11
     **/
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

    /**
     * @Description 商品种类 启用/停用
     * @Param [userId, state]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/13 2:15
     **/
    @RequestMapping("/doGoodsCategoryState")
    @ResponseBody
    public JSONObject doGoodsCategoryState(Integer categoryId, String state){
        JSONObject jsonObject = new JSONObject();
        // 查询此种类
        GoodsCategory goodsCategory = goodsCategoryService.loadByCategoryId(categoryId);
        // 启用
        if("start".equals(state)) {
            goodsCategory.setState((byte) 1);
        }
        // 停用
        if("stop".equals(state)) {
            goodsCategory.setState((byte) 2);
        }
        // 判断更新结果
        if (goodsCategoryService.updateGoodsCategory(goodsCategory) > 0) {
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
    }


    /**
     * @Description 跳转到种类修改界面
     * @Param [categoryId]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/16 18:20
     **/
    @RequestMapping("/goGoodsCategoryEdit")
    public ModelAndView doGoodsCategoryEdit(Integer categoryId){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/goods_category_manager/goods_category_edit");
        mv.addObject("goodsCategory", goodsCategoryService.loadByCategoryId(categoryId));
        mv.addObject("goodsCategoryList", goodsCategoryService.findAllListGoodsCategory());
        return mv;
    }


    /**
     * @Description 种类修改
     * @Param [goodsCategory]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/16 18:50
     **/
    @RequestMapping("/doGoodsCategoryEdit")
    @ResponseBody
    public JSONObject doGoodsCategoryEdit(GoodsCategory goodsCategory){
        JSONObject jsonObject = new JSONObject();
        GoodsCategory dbGoodsCategory = goodsCategoryService.loadByCategoryId(goodsCategory.getCategoryId());
        dbGoodsCategory.setParentId(goodsCategory.getParentId());
        dbGoodsCategory.setCategoryName(goodsCategory.getCategoryName());
        dbGoodsCategory.setSimpleDescribe(goodsCategory.getSimpleDescribe());
        dbGoodsCategory.setUpdateTime(new Date());
        if(goodsCategoryService.updateGoodsCategory(dbGoodsCategory) > 0){
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
    }


    /**
     * @Description 种类删除
     * @Param [categoryId]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/16 20:05
     **/
    @RequestMapping("/doGoodsCategoryDelete")
    @ResponseBody
    public JSONObject doGoodsCategoryDelete(Integer categoryId) {
        JSONObject jsonObject = new JSONObject();
        GoodsCategory goodsCategory = goodsCategoryService.loadByCategoryId(categoryId);
        goodsCategory.setState((byte) 3);
        if(goodsCategoryService.updateGoodsCategory(goodsCategory) > 0){
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
    }

}
