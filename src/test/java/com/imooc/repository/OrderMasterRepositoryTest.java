package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Created by Administrator on 18.4.8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    private static final String OPENID = "111111";
    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest(){

        OrderMaster orderMaster = new OrderMaster();

        orderMaster.setOrderId("123123123");
        orderMaster.setBuyerName("郭栋~");
        orderMaster.setBuyerPhone("123123123");
        orderMaster.setBuyerAddress("月球");
        orderMaster.setBuyerOpenid("111111");
        orderMaster.setOrderAmount(new BigDecimal(1235.52));

        OrderMaster save = repository.save(orderMaster);

        Assert.assertNotNull(save);

    }
    @Test
    public void findByButerOpenid() throws Exception {
        PageRequest request = new PageRequest(0,3);

        Page<OrderMaster> pa = repository.findByBuyerOpenid(OPENID, request);

        System.out.println(pa.getTotalElements());

        Assert.assertNotEquals(0,pa.getContent().size());
    }

}