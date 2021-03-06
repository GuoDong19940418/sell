package com.imooc.converter;

import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author GuoDong
 * @create 2018-04-08 下午 12:52
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO conver(OrderMaster orderMaster){

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;

    }

    public static List<OrderDTO> conver(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->
            conver(e)
        ).collect(Collectors.toList());

    }

}