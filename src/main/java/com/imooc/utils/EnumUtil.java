package com.imooc.utils;

import com.imooc.enums.CodeEnum;

/**
 * 描述:
 *
 * @author GuoDong
 * @create 2018-04-11 上午 10:44
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass){
         for(T each:enumClass.getEnumConstants()){
             if(code.equals(each.getCode())){
                 return each;
             }
         }
         return null;
    }

}