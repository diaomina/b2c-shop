package com.soft.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MessageUtil
 * @Description 发送消息题型到微信的工具类
 * @Author ljy
 * @Date 2020/2/12 12:57
 * @Version 1.0
 **/
public class MessageUtil {


    // server酱服务url
    public static final String SERVER_URL = "https://sc.ftqq.com/";
    // server酱的SCKEY
    public static final String SCKEY = "SCU81062T5fa7f841432b6de8f803a004afd0b4065e3f99e3d4034";




    /**
     * @Description 发送消息到微信
     * @Param [text 消息标题, desp 消息内容]
     * @Return java.lang.String
     * @Author ljy
     * @Date 2020/2/12 13:15
     **/
    public static String send(String text, String desp) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = SERVER_URL + SCKEY + ".send?text="+ text +"&desp=" + desp;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            // 判断消息发送结果
            if(result.endsWith("{\"errno\":0,\"errmsg\":\"success\",\"dataset\":\"done\"}")){
                System.out.println("消息发送成功！");
            } else {
                System.out.println("不妙，消息发送失败了！！！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("滴滴滴~~~ 消息发送异常！");
        } finally {
            // 使用finally块来关闭输入流
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return result;
    }

}
