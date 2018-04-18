package com.imooc.dto;

import lombok.Data;

/**
 * 描述:
 * 购物车
 *
 * @author GuoDong
 * @create 2018-04-08 上午 11:00
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}