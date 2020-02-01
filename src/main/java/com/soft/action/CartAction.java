package com.soft.action;

import com.alibaba.fastjson.JSONObject;
import com.soft.common.vo.CartVO;
import com.soft.model.Cart;
import com.soft.model.Goods;
import com.soft.model.User;
import com.soft.service.CartService;
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

    @Autowired
    private GoodsService goodsService;


    /**
     * @Description 跳转到我的购物车
     * @Param [session]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/1/30 16:49
     **/
    @RequestMapping("/goCartMain")
    public ModelAndView goCartMain(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<CartVO> cartVOList = new ArrayList<CartVO>();
        for (Cart cart : cartService.findListByUserId(user.getUserId())) {
            if (cart.getIsBuy() == 2) {
                Goods goods = goodsService.loadByGoodsId(cart.getGoodsId());
                // 判断商品是否失效，失效则置空
                if(goods.getDelState() == 1 || goods.getIsMarketable() == 0) {
                    goods = null;
                }
                // 封装cartVO
                CartVO cartVO = new CartVO();
                cartVO.setCartId(cart.getCartId());
                cartVO.setUserId(cart.getUserId());
                cartVO.setQuantity(cart.getQuantity());
                cartVO.setGoods(goods);
                cartVOList.add(cartVO);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/cart");
        mv.addObject("cartVOList", cartVOList);
        return mv;
    }


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


    /**
     * @Description 删除
     * @Param [cartId]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/1/30 21:15
     **/
    @RequestMapping("/doCartDelete")
    @ResponseBody
    public JSONObject doCartDelete(Integer cartId) {
        JSONObject jsonObject = new JSONObject();
        // 判断删除结果
        if (cartService.delCart(cartId) > 0) {
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
    }

}
