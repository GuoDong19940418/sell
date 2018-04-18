package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 18.4.7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory);
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("女女最爱",3);
        ProductCategory save = repository.save(productCategory);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);

        List<ProductCategory> list = repository.findByCategoryTypeIn(integers);
        Assert.assertNotEquals(0,list.size());

    }


}