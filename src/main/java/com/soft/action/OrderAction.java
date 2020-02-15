package com.soft.action;

import com.alibaba.fastjson.JSONObject;
import com.soft.common.util.MessageUtil;
import com.soft.common.util.OrderNumberUtil;
import com.soft.common.util.RandomNumUtil;
import com.soft.common.vo.CartVO;
import com.soft.common.vo.OrderChildVO;
import com.soft.common.vo.OrderVO;
import com.soft.model.*;
import com.soft.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
    private OrderChildService orderChildService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserReceiveService userReceiveService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;



    /**
     * @Description 将orderList封装成orderVOList
     * @Param [orderList]
     * @Return java.util.List<com.soft.common.vo.OrderVO>
     * @Author ljy
     * @Date 2020/2/9 18:00
     **/
    public List<OrderVO> getOrderVOList(List<Order> orderList) {
        List<OrderVO> orderVOList = new ArrayList<OrderVO>();
        // 封装OrderVO
        for(Order order : orderList) {
            // 获取子订单列表
            List<OrderChild> orderChildList = orderChildService.findListByOrderNumber(order.getOrderNumber());
            List<OrderChildVO> orderChildVOList = new ArrayList<OrderChildVO>();
            // 获取商品信息
            for(OrderChild orderChild : orderChildList) {
                Goods goods = goodsService.loadByGoodsId(orderChild.getGoodsId());
                // 封装OrderChildVO
                OrderChildVO orderChildVO = new OrderChildVO();
                orderChildVO.setOrderChildId(orderChild.getOrderChildId());
                orderChildVO.setGoods(goods);
                orderChildVO.setQuantity(orderChild.getQuantity());
                orderChildVOList.add(orderChildVO);
            }
            // 封装OrderVO
            OrderVO orderVO = new OrderVO();
            orderVO.setOrderId(order.getOrderId());
            orderVO.setOrderNumber(order.getOrderNumber());
            orderVO.setUser(userService.loadByUserId(order.getUserId()));
            orderVO.setTotalAmount(order.getTotalAmount());
            orderVO.setUserReceive(userReceiveService.loadById(order.getReceiveId()));
            orderVO.setOrderChildVOList(orderChildVOList);
            orderVO.setSendTime(order.getSendTime());
            orderVO.setLogisticsState(order.getLogisticsState());
            orderVO.setPayState(order.getPayState());
            orderVO.setCreateTime(order.getCreateTime());
            orderVO.setUpdateTime(order.getUpdateTime());
            orderVOList.add(orderVO);
        }
        return orderVOList;
    }


    /**
     * @Description 跳转到 订单管理-所有订单 界面
     * @Param []
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/9 18:09
     **/
    @RequestMapping("/goOrderMain")
    public ModelAndView goOrderMain() {
        // 获取所有订单
        List<Order> orderList = orderService.findAllList();
        // 去除删除的订单
        Iterator<Order> iterator = orderList.iterator();
        while(iterator.hasNext()) {
            Order order = iterator.next();
            // 判断订单是否删除，删除则去除且跳出本次循环
            if(order.getDelState() == 1) {
                iterator.remove();
                continue;
            }
        }
        return new ModelAndView("admin/order_manager/order_main", "orderVOList", getOrderVOList(orderList));
    }



    /**
     * @Description 跳转到 订单管理-订单编辑 界面
     * @Param [orderId]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/10 14:50
     **/
    @RequestMapping("/goOrderEdit")
    public ModelAndView goOrderEdit(Integer orderId) {
        ModelAndView mv = new ModelAndView();
        Order order = orderService.loadByOrderId(orderId);
        mv.setViewName("admin/order_manager/order_edit");
        mv.addObject("order", order);
        mv.addObject("userReceive", userReceiveService.loadById(order.getReceiveId()));
        return mv;
    }



    /**
     * @Description 订单管理-订单编辑
     * @Param [orderId, totalAmount, userReceive]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/2/10 15:27
     **/
    @RequestMapping("/doOrderEdit")
    @ResponseBody
    public JSONObject doOrderEdit(Integer orderId, Double totalAmount ,UserReceive userReceive) {
        JSONObject jsonObject = new JSONObject();
        // 更新订单
        Order order = orderService.loadByOrderId(orderId);
        order.setTotalAmount((int)(totalAmount*100));
        order.setUpdateTime(new Date());
        // 地址如有更新，则创建一个新地址给此订单使用，该地址不属于用户，只属于该订单
        UserReceive dbUserReceive = userReceiveService.loadById(userReceive.getReceiveId());
        if(dbUserReceive.getContact().equals(userReceive.getContact()) &&
                dbUserReceive.getTel().equals(userReceive.getTel()) &&
                dbUserReceive.getReceiveProvince().equals(userReceive.getReceiveProvince()) &&
                dbUserReceive.getReceiveCity().equals(userReceive.getReceiveCity()) &&
                dbUserReceive.getReceiveCounty().equals(userReceive.getReceiveCounty()) &&
                dbUserReceive.getReceiveAddress().equals(userReceive.getReceiveAddress())){
            // 无更新
        } else {
            // 有更新
            // 生成地址id,创建新地址
            Integer receiveId = RandomNumUtil.getRandomNum();
            userReceive.setReceiveId(receiveId);
            userReceive.setCreateTime(new Date());
            userReceive.setUpdateTime(new Date());
            if(userReceiveService.createUserReceive(userReceive) >= 0) {
                order.setReceiveId(receiveId);
            }
        }
        
        // 判断更新结果
        if(orderService.updateOrder(order) >= 0) {
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
        }
        return jsonObject;
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
        List<CartVO> cartVOList = new ArrayList<CartVO>();
        for (Integer cartId : cartIds) {
            Cart cart = cartService.loadByCartId(cartId);
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

        // 获取用户地址簿
        User user = (User) session.getAttribute("user");
        List<UserReceive> userReceiveList = userReceiveService.findListByUserId(user.getUserId());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/my_order/order_add");
        mv.addObject("cartVOList", cartVOList);
        mv.addObject("userReceiveList", userReceiveList);
        return mv;
    }


    /**
     * @Description 订单创建
     * @Param [cartIds, order, session]
     * @Return java.lang.String
     * @Author ljy
     * @Date 2020/2/7 17:11
     **/
    @RequestMapping("/doOrderAdd")
    public String doOrderAdd(Integer[] cartIds, Order order, HttpSession session) {
        // 生成不重复订单号
        String orderNumber = OrderNumberUtil.getOrderNumber();
        order.setOrderNumber(orderNumber);
        // 获取用户id
        User user = (User) session.getAttribute("user");
        order.setUserId(user.getUserId());
        // 获取时间
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());

        // 获取购物车列表
        List<Cart> cartList = new ArrayList<Cart>();
        for (Integer cartId : cartIds) {
            if(cartId != null) {
                Cart cart = cartService.loadByCartId(cartId);
                cartList.add(cart);
            }
        }

        for (Cart cart : cartList) {
            // 生成子订单
            OrderChild orderChild = new OrderChild();
            orderChild.setOrderNumber(orderNumber);
            orderChild.setGoodsId(cart.getGoodsId());
            orderChild.setQuantity(cart.getQuantity());
            orderChild.setCreateTime(new Date());
            orderChild.setUpdateTime(new Date());
            orderChildService.createOrderChild(orderChild);
            // 将购物车内商品信息更新为已购买
            cart.setIsBuy((byte) 1);
            cartService.updateCart(cart);
        }

        int flag = orderService.createOrder(order);
        System.out.println(flag);
        return "redirect:/orderAction/goOrderState?state=pay&code=1";
    }


    /**
     * @Description 跳转到不同状态的订单界面
     * @Param [state, code, session]
     * @Return org.springframework.web.servlet.ModelAndView
     * @Author ljy
     * @Date 2020/2/7 13:21
     **/
    @RequestMapping("/goOrderState")
    public ModelAndView goOrderState(String state, Integer code, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        User user = (User) session.getAttribute("user");
        List<Order> orderList = orderService.findListByUserId(user.getUserId());
        Iterator<Order> iterator = orderList.iterator();
        while(iterator.hasNext()) {
            Order order = iterator.next();
            // 判断订单是否删除，删除则去除且跳出本次循环
            if(order.getDelState() == 1) {
                iterator.remove();
                continue;
            }
            // 根据支付状态
            if("pay".equals(state)) {
                // 获取未付款订单 code:1
                if(order.getPayState() != code.byteValue()) {
                    iterator.remove();
                }
            }
            // 根据物流状态
            if("logistics".equals(state)) {
                if(order.getPayState() != 2 || order.getLogisticsState() != code.byteValue()) {
                    iterator.remove();
                }
            }
        }

        // 获取OrderVO
        List<OrderVO> orderVOList = getOrderVOList(orderList);

        // 设置跳转的view
        if("pay".equals(state) && code == 1) {
            mv.setViewName("user/my_order/order_state_pay_1");
        }
        if("logistics".equals(state)) {
            switch (code) {
                case 1:     // 待发货订单
                    mv.setViewName("user/my_order/order_state_logistics_1");
                    break;
                case 2:     // 待收货订单
                    mv.setViewName("user/my_order/order_state_logistics_2");
                    break;
                case 3:     // 已完成订单
                    mv.setViewName("user/my_order/order_state_logistics_3");
                    break;
                default:mv.setViewName("user/my_order/order_state_pay_1");
            }
        }
        mv.addObject("orderVOList", orderVOList);
        return mv;
    }


    /**
     * @Description 订单支付(账户余额支付)
     * @Param [mode, orderId]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/2/8 17:07
     **/
    @RequestMapping("/doPay")
    @ResponseBody
    public JSONObject doPay(Integer orderId){
        JSONObject jsonObject = new JSONObject();
        Order order = orderService.loadByOrderId(orderId);
        // 获取用户信息
        User user = userService.loadByUserId(order.getUserId());
        // 判断账户余额是否充足
        Integer number = user.getUserAmount() - order.getTotalAmount();
        if(number >= 0){
            // 余额充足,完成支付
            user.setUserAmount(number);
            if(userService.updateUser(user) > 0) {
                order.setPayState((byte) 2);
                order.setUpdateTime(new Date());
                if(orderService.updateOrder(order) > 0){
                    jsonObject.put("flag","true");
                    // 支付成功，修改商品库存数量
                    List<OrderChild> orderChildList = orderChildService.findListByOrderNumber(order.getOrderNumber());
                    for (OrderChild orderChild : orderChildList) {
                        Goods goods = goodsService.loadByGoodsId(orderChild.getGoodsId());
                        goods.setQuantity(goods.getQuantity() - orderChild.getQuantity());
                        goodsService.updateGoods(goods);
                    }
                    // 发送提醒消息到管理员微信
                    MessageUtil.send("订单提醒服务", "您有一个新订单,订单号："+order.getOrderNumber()+" ,请注意查看哟~");
                }
            } else {
                // 支付失败
                jsonObject.put("flag","false");
            }
        } else {
            // 余额不足,支付失败
            jsonObject.put("msg","您的余额不足，请充值!");
            jsonObject.put("flag","false");
        }
        return jsonObject;
    }


    /**
     * @Description 订单取消
     * @Param [orderId]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/2/7 19:17
     **/
    @RequestMapping("/doOrderDelete")
    @ResponseBody
    public JSONObject doOrderDelete(Integer orderId) {
        JSONObject jsonObject = new JSONObject();
        Order order = orderService.loadByOrderId(orderId);
        order.setDelState((byte) 1);
        // 判断修改是否成功
        if(orderService.updateOrder(order) > 0) {
            jsonObject.put("flag","true");
        } else {
            jsonObject.put("flag","false");
        }
        return jsonObject;
    }


    /**
     * @Description 订单管理-批量删除
     * @Param [orderIds]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/2/11 17:00
     **/
    @RequestMapping("/doDelBatchOrder")
    @ResponseBody
    public JSONObject doDelBatchOrder(@RequestParam(value="orderIds[]")Integer[] orderIds) {
        JSONObject jsonObject = new JSONObject();
        List<Integer> list = new ArrayList<Integer>();
        for (Integer orderId : orderIds) {
            list.add(orderId);
        }
        int recordNumber = orderService.delBatchOrder(list);
        if(recordNumber == list.size()){
            jsonObject.put("flag", "true");
        } else {
            jsonObject.put("flag", "false");
            jsonObject.put("number", list.size() - recordNumber);
        }
        return jsonObject;
    }


    /**
     * @Description 更新订单配送状态
     * @Param [orderId, logisticsState (2 确认发货,3 确认收货)]
     * @Return com.alibaba.fastjson.JSONObject
     * @Author ljy
     * @Date 2020/2/8 18:41
     **/
    @RequestMapping("/doOrderLogisticsUpdate")
    @ResponseBody
    public JSONObject doOrderLogisticsUpdate(Integer orderId,Integer logisticsState) {
        JSONObject jsonObject = new JSONObject();
        Order order = orderService.loadByOrderId(orderId);
        order.setLogisticsState(logisticsState.byteValue());
        order.setUpdateTime(new Date());
        // 如果是"确认发货"操作,则添加发货时间
        if(logisticsState == 2) {
            order.setSendTime(new Date());
        }
        // 判断修改是否成功
        if(orderService.updateOrder(order) > 0) {
            jsonObject.put("flag","true");
        } else {
            jsonObject.put("flag","false");
        }
        return jsonObject;
    }

}
