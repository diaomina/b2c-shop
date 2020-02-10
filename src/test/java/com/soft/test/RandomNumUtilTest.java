package com.soft.test;

import com.soft.common.util.RandomNumUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description 测试随机数生成工具类
 * @Author ljy
 * @Date 2020/2/10 15:52
 **/

public class RandomNumUtilTest {

    @Test
    public void genRandomNum() {
        for(int i=0 ; i<50 ; i++) {
            System.out.println(RandomNumUtil.getRandomNum());
        }

    }
}