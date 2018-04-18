package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 18.4.14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {
    @Test
    public void findByCategoryName() throws Exception {
    }

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("category_name","师兄最爱");
        map.put("category_type",222);
        int result = mapper.insertByMap(map);

        Assert.assertEquals(1,result);
    }

    @Test
    public void insertByObject() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("师兄最爱爱");
        productCategory.setCategoryType(2222);
        mapper.insertByObject(productCategory);

    }

    @Test
    public void findByCategoryType(){
        ProductCategory byCategoryType = mapper.findByCategoryType(222);

        Assert.assertNotNull(byCategoryType);
    }

    @Test
    public void findByCategoryNameTest(){
        List<ProductCategory> sx = mapper.findByCategoryName("师兄");
        Assert.assertEquals(2,sx.size());
    }

    @Test
    public void updateByCategoryType(){
        int result = mapper.updateByCategoryType("湿胸最爱", 2222);
        Assert.assertNotEquals(0,result);
    }

    @Test
    public void updateByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(7);
        productCategory.setCategoryName("师母最爱");
        productCategory.setCategoryType(223);
        int i = mapper.updateByObject(productCategory);

        Assert.assertNotEquals(0,1);
    }

    @Test
    public void deleteByCategoryType(){
        int i = mapper.deleteByCategoryType(2222);

        Assert.assertEquals(1,i);
    }

    @Test
    public void selectByCategoryType(){
        ProductCategory productCategory = mapper.selectByCategoryType(222);
        Assert.assertNotNull(productCategory);
    }



}