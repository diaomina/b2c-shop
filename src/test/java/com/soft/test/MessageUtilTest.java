package com.soft.test;

import com.soft.common.util.MessageUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ljy
 * @date
 */
public class MessageUtilTest {

    @Test
    public void send() {
        System.out.println(MessageUtil.send("这里是标题！！！","这里是内容！！！"));
    }
}