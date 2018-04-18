package com.imooc.form;

import lombok.Data;

/**
 * 描述:
 * 类目表单
 *
 * @author GuoDong
 * @create 2018-04-11 下午 7:15
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

}