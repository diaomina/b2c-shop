package com.soft.action;

import com.soft.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/goOrderMain")
    public ModelAndView goOrderMain() {
        ModelAndView mv = new ModelAndView();

        return mv;
    }

}
