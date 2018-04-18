package com.imooc.utils;

import java.util.Random;

/**
 * 描述:
 * 随机生成工具
 *
 * @author GuoDong
 * @create 2018-04-08 上午 10:44
 */
public class KeyUtil {

    public static synchronized String genUniqueKey(){
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis()+String.valueOf(number);
    }

}