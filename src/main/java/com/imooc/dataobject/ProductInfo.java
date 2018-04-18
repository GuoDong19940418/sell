package com.imooc.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:
 * 商品信息
 *
 * @author GuoDong
 * @create 2018-04-07 上午 10:22
 */
@Entity
@DynamicUpdate
@Data
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 6399186181668983148L;

    @Id
    private String productId;

    private String productName;         //名字

    private BigDecimal productPrice;    //单价

    private Integer productStock;       //库存

    private String productDescription;  //描述

    private String productIcon;         //小图

    private Integer productStatus = ProductStatusEnum.UP.getCode();      //状态 0正常1下架

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }

}