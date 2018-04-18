package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author GuoDong
 * @create 2018-04-11 下午 9:08
 */
@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrlConfig {

    /**
     * 微信公众号授权url
     */
    public String wecharMpAuthorize;

    /**
     * 微信开放平台授权url
     */
    public String wecharOpenAuthorize;

    /**
     * 项目url
     */
    public String sell;

    /**
     * 租用账号二维码代理登录
     */
    public String agencyUrl;
}