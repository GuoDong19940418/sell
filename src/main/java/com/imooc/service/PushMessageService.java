package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * Created by Administrator on 18.4.13.
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
