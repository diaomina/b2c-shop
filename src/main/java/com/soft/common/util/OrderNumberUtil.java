package com.soft.common.util;

import org.jetbrains.annotations.TestOnly;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName OrderNumberUtil
 * @Description 生成唯一不重复订单号
 * @Author ljy
 * @Date 2020/2/3 18:08
 * @Version 1.0
 **/
public class OrderNumberUtil {

    public static String getOrderNumber() {
        // 获取时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateTime = sdf.format(new Date());

        // 生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();

        // 生成随机数
        String ranEight = String.format("%08d", new Random().nextInt(99999999));

        return dateTime + uuid + ranEight;
    }

}
