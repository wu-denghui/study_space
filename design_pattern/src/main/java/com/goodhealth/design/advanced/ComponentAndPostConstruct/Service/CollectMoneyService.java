package com.goodhealth.design.advanced.ComponentAndPostConstruct.Service;

import com.goodhealth.design.advanced.ComponentAndPostConstruct.ServiceEnum;
import org.springframework.stereotype.Component;

/**
 * @ClassName CollectMoneyService
 * @Description 收钱动作
 * @Author WDH
 * @Date 2019/9/4 21:34
 * @Version 1.0
 **/
@Component
public class CollectMoneyService extends AbstractService{

    @Override
    public void doSomething() {
        System.out.println("收钱");
    }

    @Override
    public ServiceEnum getServiceEnum() {
        return ServiceEnum.COLLECT_MONEY;
    }

}
