package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 18.4.8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setDetailId("123123");
        orderDetail.setOrderId("123123");
        orderDetail.setProductId("222");
        orderDetail.setProductName("皮皮虾2");
        orderDetail.setProductPrice(new BigDecimal(2.2));
        orderDetail.setProductQuantity(3);
        orderDetail.setProductIcon("http:xxx.jpg");

        OrderDetail save = repository.save(orderDetail);

        Assert.assertNotNull(save);

    }

    @Test
    public void findByOrderId() throws Exception {

        List<OrderDetail> byOrderId = repository.findByOrderId("123123");
        Assert.assertEquals(2,byOrderId.size());

    }

}