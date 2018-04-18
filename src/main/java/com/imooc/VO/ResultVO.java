package com.imooc.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author GuoDong
 * @create 2018-04-07 上午 11:22
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 3068837394742385883L;

    //错误码
    private Integer code;
    //提示信息
    private String msg;
    // 具体内容
    private T data;


}