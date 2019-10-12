package com.goodhealth.design.advanced.ComponentAndPostConstruct;

import com.goodhealth.design.advanced.ComponentAndPostConstruct.context.ICashierService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName Client
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/4 21:52
 * @Version 1.0
 **/
public class Client {

    @Autowired
    private ICashierService cashierService;

    public static void main(String[] args){
//        cashierService.getService(ServiceEnum.GIVECHANGE).doSomething();
    }
}
