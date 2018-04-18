package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 18.4.7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();

        productInfo.setProductId("2221113");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(5.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的周");
        productInfo.setProductIcon("http://xxx.gif");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);

        ProductInfo save = repository.save(productInfo);

        Assert.assertNotNull(save);

    }

    @Test
    public void findByProductStatusTest() throws Exception {

        List<ProductInfo> byProductStatus = repository.findByProductStatus(0);

        Assert.assertNotEquals(0,byProductStatus.size());
    }

}