package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 * 微信授权测试
 *
 * scope=snsapi_base的方式获取code
 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2e5124d8e7699c53&redirect_uri=http%3A%2F%2Fguodongandjava.natapp1.cc%2Fsell%2Fweixin%2Fauth&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
 *
 * 获取code后，请求以下链接获取access_token
 * String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx2e5124d8e7699c53&secret=00c39571f1abbce460724fbe25d96524&code="+code+"&grant_type=authorization_code";
 *
 * 访问上面地址,返回下面JSON
 * {
 *      "access_token" : "8_6m9xJcq61PqsddZBLKIPpa4TqcPFfkT_u_m3QupQ_DYrFN-2WZpz1dxTwHqFsNW0kIT8wCQ1BgjvjWrAlhMWYg",
 *      "expires_in" : 7200,
 *      "openid" : "orrSn1VdkFLpDhT6MxEI245EpTuk",
 *      "refresh_token" : "8_FSISZLiKFn1hVdIgt5t0QLBmaJdbpnEZIUhufL--qMQf0Lc3Aa5fKtUW2y53L1oKdWqBKfNyvKA0-rV7nthUiA",
 *      "scope" : "snsapi_base"
 * }
 *
 * @author GuoDong
 * @create 2018-04-08 下午 9:07
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
        log.info("进入auth方法");
        log.info("code={}",code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx2e5124d8e7699c53&secret=00c39571f1abbce460724fbe25d96524&code="+code+"&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        log.info("response={}",response);
    }
}