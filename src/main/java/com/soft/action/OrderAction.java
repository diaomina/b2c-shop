package com.soft.action;

import com.alibaba.fastjson.JSONObject;
import com.soft.common.util.OrderNumberUtil;
import com.soft.model.Cart;
import com.soft.model.Order;
import com.soft.model.User;
import com.soft.model.UserReceive;
import com.soft.service.CartService;
import com.soft.service.OrderService;
import com.soft.service.UserReceiveService;
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
 * @ClassName OrderAction
 * @Description 订单管理控制器
 * @Author ljy
 * @Date 2020/1/27 20:08
 * @Version 1.0
 **/
@Controller
@RequestMapping("/orderAction")
public class OrderAction {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserReceiveService userReceiveService;



    @RequestMapping("/goOrderMain")
    public ModelAndView goOrderMain() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }


    /**
     * @Description 跳转到订单创建界面(结算界面)
     * @Param [cartIds, session]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/3 18:34
     **/
    @RequestMapping("/goOrderAdd")
    public ModelAndView goOrderAdd(Integer[] cartIds, HttpSession session) {
        // 获取购物车中商品信息
        List<Cart> cartList = new ArrayList<Cart>();
        for (Integer cartId : cartIds) {
            Cart cart = cartService.loadByCartId(cartId);
            cartList.add(cart);
        }
        // 获取用户地址簿
        User user = (User) session.getAttribute("user");
        List<UserReceive> userReceiveList = userReceiveService.findListByUserId(user.getUserId());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/my_order/order_add");
        mv.addObject("cartList", cartList);
        mv.addObject("userReceiveList", userReceiveList);
        return mv;
    }


    /**
     * @Description 订单创建
     * @Param [cartIds]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/2/3 17:56
     **/
    @RequestMapping("/doOrderAdd")
    @ResponseBody
    public JSONObject doOrderAdd(Integer[] cartIds) {
        JSONObject jsonObject = new JSONObject();
        List<Cart> cartList = new ArrayList<Cart>();
        for (Integer cartId : cartIds) {
            Cart cart = cartService.loadByCartId(cartId);
            cartList.add(cart);
        }

        // 创建订单
        Order order = new Order();
        // 生成不重复订单号
        String orderNumber = OrderNumberUtil.getOrderNumber();


        // 判断添加结果
        if (orderService.createOrder(order) > 0) {
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
    }

}
