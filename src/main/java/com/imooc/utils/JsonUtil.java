package com.imooc.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 描述:
 * JSON转换工具
 *
 * @author GuoDong
 * @create 2018-04-09 下午 8:18
 */
public class JsonUtil {

    //对象转JSON
    public static String toJson(Object obj){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(obj);
    }



}