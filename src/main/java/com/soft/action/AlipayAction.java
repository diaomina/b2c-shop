package com.soft.action;

import ch.qos.logback.classic.Logger;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.soft.common.config.AlipayConfig;
import com.soft.model.Order;
import com.soft.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName AlipayAction
 * @Description 支付宝支付控制器
 * @Author ljy
 * @Date 2020/2/13 20:58
 * @Version 1.0
 **/
@Controller
@RequestMapping("/alipayAction")
public class AlipayAction {


    @Autowired
    private OrderService orderService;


    /**
     * @Description 根据订单信息生成表单，跳转到支付界面
     * @Param [order, request, response]
     * @Return void
     * @Author ljy
     * @Date 2020/2/13 21:01
     **/
    @RequestMapping("/goAlipay")
    public void goAlipay(Order order, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获得初始化的AlipayClient
        PrintWriter out = response.getWriter();
        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayConfig.URL, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY,
                AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);


        // 给订单总金额单位转换为元
        StringBuffer sb = new StringBuffer(String.valueOf(order.getTotalAmount()));
        sb.insert(sb.length()-3, ".");

        String out_trade_no = order.getOrderNumber();  // 商户订单号，商户网站订单系统中唯一订单号，必填
        String total_amount = sb.toString();  // 付款金额，必填
        String subject = "B2C商城购物";  // 商品名称
        String returnUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/orderAction/goOrderState?state=logistics&code=1";

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
        alipayRequest.setReturnUrl(returnUrl);
        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");// 在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" + "    \"out_trade_no\":\""+out_trade_no+"\","
                + "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," + "    \"total_amount\":"+total_amount+","
                + "    \"subject\":\""+subject+"\"," + "    \"body\":\""+subject+"\","
                + "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","
                + "    \"extend_params\":{" + "    \"sys_service_provider_id\":\"2088511833207846\"" + "    }" + "  }");// 填充业务参数
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        response.getWriter().write(form);// 直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }





    /**
     * @Description: 支付宝回调接口
     * @param out_trade_no 商户订单号
     * @param trade_no     支付宝交易凭证号
     * @param trade_status 交易状态
     * @return String
     * @throws AlipayApiException
     */
    @PostMapping("notify")
    private String alipayNotify(HttpServletRequest request, String out_trade_no, String trade_no, String trade_status)
            throws AlipayApiException {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            map.put(name, valueStr);
        }
        boolean signVerified = false;

        try {
            signVerified = AlipaySignature.rsaCheckV1(map, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGN_TYPE);
        } catch (com.alipay.api.AlipayApiException e) {
            System.out.println("notify 验证失败");
            e.printStackTrace();
            return ("--failed--");
        }
        if (signVerified) {
            //处理你的业务逻辑，更细订单状态等

            return ("--success--");
        } else {
            System.out.println("验证失败,不去更新状态");
            return ("--failed--");
        }
    }



    /**
     * @Description: 支付宝回调接口
     * @param out_trade_no 商户订单号
     * @param trade_no     支付宝交易凭证号
     * @return String
     * @throws AlipayApiException
     */
    @GetMapping("return")
    private String alipayReturn(Map<String, String> params, HttpServletRequest request, String out_trade_no, String trade_no, String total_amount)
            throws AlipayApiException {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                System.out.println(valueStr);
            }
            map.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(map, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGN_TYPE);
        } catch (AlipayApiException e) {
            System.out.println("支付宝回调异常");
            e.printStackTrace();
            // 验签发生异常,则直接返回失败
            return ("--fail--");
        }
        if (signVerified) {
            return ("--success--");
        } else {
            return ("fail");
        }
    }

}
