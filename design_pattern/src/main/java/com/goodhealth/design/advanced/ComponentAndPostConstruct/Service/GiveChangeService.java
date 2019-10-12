package com.goodhealth.design.advanced.ComponentAndPostConstruct.Service;

import com.goodhealth.design.advanced.ComponentAndPostConstruct.ServiceEnum;
import org.springframework.stereotype.Component;

/**
 * @ClassName GiveChangeService
 * @Description  找钱动作
 * @Author WDH
 * @Date 2019/9/4 21:38
 * @Version 1.0
 **/
@Component
public class GiveChangeService extends AbstractService {

    @Override
    public void doSomething() {
        System.out.println("找零");
    }

    @Override
    public ServiceEnum getServiceEnum() {
        return ServiceEnum.GIVECHANGE;
    }

}
