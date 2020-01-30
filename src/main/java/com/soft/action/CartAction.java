package com.soft.action;

import com.alibaba.fastjson.JSONObject;
import com.soft.model.Cart;
import com.soft.model.User;
import com.soft.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @ClassName CartAction
 * @Description 购物车的控制器
 * @Author ljy
 * @Date 2020/1/30 15:37
 * @Version 1.0
 **/
@Controller
@RequestMapping("/cartAction")
public class CartAction {

    @Autowired
    private CartService cartService;


    /**
     * @Description 立即订购 - 将商品加入购物车
     * @Param [goodsId, goodsNum]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/30 15:39
     **/
    @RequestMapping("/doCartAdd")
    @ResponseBody
    public JSONObject doCartAdd(Integer goodsId, Integer goodsNum, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        User user = (User) session.getAttribute("user");
        Cart cart = new Cart();
        cart.setUserId(user.getUserId());
        cart.setGoodsId(goodsId);
        cart.setQuantity(goodsNum);
        cart.setCreateTime(new Date());
        cart.setUpdateTime(new Date());

        // 判断添加结果
        if (cartService.createCart(cart) > 0) {
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
    }

}
