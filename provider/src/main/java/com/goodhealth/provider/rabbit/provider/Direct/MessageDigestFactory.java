package com.goodhealth.provider.rabbit.provider.Direct;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName MessageDigestFactory
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/14 10:55
 * @Version 1.0
 **/
@Component
public class MessageDigestFactory {


    @Bean
    public MessageDigest CreatMessageDigest() throws NoSuchAlgorithmException {
        return  MessageDigest.getInstance("md5");
    }
}
