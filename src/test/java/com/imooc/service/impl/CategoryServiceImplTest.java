package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 18.4.7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl service;

    @Test
    public void findOne() throws Exception {
        ProductCategory one = service.findOne(1);
        Assert.assertEquals(new Integer(1),one.getCategoryId());

    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> all = service.findAll();
        Assert.assertNotNull(all);
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> byCategoryTypeIn = service.findByCategoryTypeIn(Arrays.asList(1, 2, 3, 4));

        Assert.assertEquals(new Integer(2),byCategoryTypeIn);

    }

    @Test
    @Transactional
    public void save() throws Exception {
        ProductCategory  a= service.save(new ProductCategory("男男111最爱", 5));

        Assert.assertNotNull(a);

    }

}