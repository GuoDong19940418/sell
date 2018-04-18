package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 18.4.7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl service;

    @Test
    public void findOne() throws Exception {
        ProductInfo info = service.findOne("2221113");
        Assert.assertEquals("2221113",info.getProductId());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> all = service.findAll(pageRequest);
        long totalElements = all.getTotalElements();
        List<ProductInfo> content = all.getContent();

        Assert.assertEquals(2,content.size());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> upAll = service.findUpAll();
        Assert.assertEquals(1,upAll.size());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();

        productInfo.setProductId("222");
        productInfo.setProductName("皮皮虾222");
        productInfo.setProductPrice(new BigDecimal(5.5));
        productInfo.setProductStock(222);
        productInfo.setProductDescription("很活泼的虾222");
        productInfo.setProductIcon("http://xxx.gif222");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo save = service.save(productInfo);

        Assert.assertEquals("222",save.getProductId());
    }

    @Autowired
    private ProductService productService;

    @Test
    public void onSale(){
        ProductInfo productInfo = productService.onSale("222");
        Assert.assertEquals(ProductStatusEnum.UP.getCode(),productInfo.getProductStatus());
    }

    @Test
    public void offSale(){
        ProductInfo productInfo = productService.offSale("222");
        Assert.assertEquals(ProductStatusEnum.DOWN.getCode(),productInfo.getProductStatus());
    }

}