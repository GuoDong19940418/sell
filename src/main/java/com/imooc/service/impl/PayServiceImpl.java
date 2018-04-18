package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import com.imooc.service.PayService;
import com.imooc.utils.JsonUtil;
import com.imooc.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 支付业务
 *
 * @author GuoDong
 * @create 2018-04-09 上午 11:59
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static final String ORDER_NAME = "微信点餐订单";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;

    /**
     * 创建支付订单
     * @param orderDTO
     */
    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        //给支付请求添加openid
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        //给支付请求添加价格
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        //给支付请求添加订单号
        payRequest.setOrderId(orderDTO.getOrderId());
        //给支付请求添加订单名
        payRequest.setOrderName(ORDER_NAME);
        //给支付请求设置支付类型
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("[微信支付]发起支付,request={}", JsonUtil.toJson(payRequest));

        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("[微信支付]发起支付,response={}",JsonUtil.toJson(payResponse));

        return payResponse;
    }

    /**
     * 微信支付后返回的异步通知
     * @param notifyData
     * @return
     */
    @Override
    public PayResponse notify(String notifyData) {
        //1.验证签名,验证是不是微信返回的通知
        //2.支付的状态,判断是否成功支付
        //3.支付的金额,判断支付金额是否正确
        //4.支付人,判断是否是下单人支付,根据业务判断是否可以代付

        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("[微信支付]异步通知,payResponse={}", JsonUtil.toJson(payResponse));

        //修改订单支付状态
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());
        if(orderDTO == null){
            log.error("[微信支付]异步通知,订单不存在,orderId={}",payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //判断金额是否一致(0.10 与 0.1不相等)
        if(!MathUtil.equals(orderDTO.getOrderAmount().doubleValue(),payResponse.getOrderAmount())){
            log.error("[微信支付]异步通知,订单金额与支付金额不一致,orderId={},微信通知金额={},系统金额={}",
                    payResponse.getOrderId(), payResponse.getOrderAmount(),orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }

        orderService.paid(orderDTO);

        return payResponse;
    }

    /**
     * 退款
     * @param orderDTO
     */
    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("[微信退款]request={}",JsonUtil.toJson(refundRequest));

        RefundResponse refundResponse = bestPayService.refund(refundRequest);
        log.info("[微信退款]response={}",JsonUtil.toJson(refundResponse));

        return refundResponse;
    }

}