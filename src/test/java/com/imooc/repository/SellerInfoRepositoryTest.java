package com.imooc.repository;

import com.imooc.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 18.4.11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void saveTest(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setOpenid("abc");
        sellerInfo.setPassword("abc");
        sellerInfo.setSellerId("abc");
        sellerInfo.setUsername("abc");
        repository.save(sellerInfo);
    }

    @Test
    public void findByOpenid() throws Exception {
        SellerInfo abc = repository.findByOpenid("abc");
        Assert.assertEquals("abc",abc.getPassword());
    }

}