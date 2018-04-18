package com.imooc.service.impl;

import com.imooc.dataobject.SellerInfo;
import com.imooc.service.SellerService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class SellerServiceImplTest {

    @Autowired
    private SellerService sellerService;

    private static final String OPEN_ID = "abc";

    @Test
    public void findSellerInfoByOpenId() throws Exception {
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenId(OPEN_ID);
        Assert.assertEquals("abc",sellerInfo.getPassword());
    }

}