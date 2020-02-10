package com.soft.common.util;

import java.util.Random;

/**
 * @ClassName RandomNumUtil
 * @Description 生成不重复随机数的工具类
 * @Author ljy
 * @Date 2020/2/10 15:41
 * @Version 1.0
 **/
public class RandomNumUtil {

    public static Integer getRandomNum(){
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        String result = "";
        for(int i = 0; i < 8; i++){
            result += array[i];
        }
        return Integer.valueOf(result);
    }

}
