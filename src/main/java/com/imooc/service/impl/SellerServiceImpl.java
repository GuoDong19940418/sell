package com.imooc.service.impl;

import com.imooc.dataobject.SellerInfo;
import com.imooc.repository.SellerInfoRepository;
import com.imooc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author GuoDong
 * @create 2018-04-11 下午 8:08
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenId(String openid) {
        SellerInfo sellerInfo = repository.findByOpenid(openid);
        return sellerInfo;
    }
}