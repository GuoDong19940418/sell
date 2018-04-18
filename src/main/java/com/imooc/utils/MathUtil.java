package com.imooc.utils;

/**
 * 描述:
 * 数据工具
 *
 * @author GuoDong
 * @create 2018-04-10 下午 1:35
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    public static Boolean equals(Double d1,Double d2){
        Double result = Math.abs(d1-d2);
        if(result < MONEY_RANGE){
            return true;
        }else {
            return false;
        }
    }

}