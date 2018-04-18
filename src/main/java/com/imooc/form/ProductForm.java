package com.imooc.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述:
 * 商品表单对象
 *
 * @author GuoDong
 * @create 2018-04-11 下午 4:50
 */
@Data
public class ProductForm {

    private String productId;

    private String productName;         //名字

    private BigDecimal productPrice;    //单价

    private Integer productStock;       //库存

    private String productDescription;  //描述

    private String productIcon;         //小图

    private Integer categoryType;



}