package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

/**
 * Created by Administrator on 18.4.11.
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenId(String openid);

}
