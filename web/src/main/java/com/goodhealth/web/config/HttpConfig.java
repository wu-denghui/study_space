package com.goodhealth.web.config;

import com.goodhealth.framework.config.AbstractHttpConfig;
import com.goodhealth.web.http.HttpApiBaiDu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author WDH
 * @Date 2019/9/23 9:34
 **/
@Configuration
public class HttpConfig extends AbstractHttpConfig {
    /**
     * baidu host
     */
    @Value("${http.host.Baidu}")
    private String bdHttpHost;

    /**
     * 配置BaiDu请求
     * @return
     */
    @Bean
    public HttpApiBaiDu getNpsApi() {
        return super.getBuilder(bdHttpHost).create(HttpApiBaiDu.class);
    }

}
