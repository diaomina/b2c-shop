package com.soft.action;

import com.alibaba.fastjson.JSONObject;
import com.soft.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName GoodsAction
 * @Description 商品控制器
 * @Author ljy
 * @Date 2020/1/16 20:11
 * @Version 1.0
 **/
@Controller
@RequestMapping("/goods")
public class GoodsAction {

    @Autowired
    private GoodsService goodsService;

    /**
     * @Description 跳转到商品管理主页
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/18 23:12
     **/
    @RequestMapping("/goGoodsMain")
    public ModelAndView goGoodsMain(){
        return new ModelAndView("admin/goods_manager/goods_main", "goodsList", goodsService.findAllListGoods());
    }

}
