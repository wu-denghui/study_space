package com.goodhealth.design.advanced.ComponentAndPostConstruct.Service;

import com.goodhealth.design.advanced.ComponentAndPostConstruct.ServiceEnum;
import com.goodhealth.design.advanced.ComponentAndPostConstruct.context.Cashier;

import javax.annotation.PostConstruct;

/**
 * @ClassName AbstractService
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/5 18:45
 * @Version 1.0
 **/
public abstract class AbstractService implements IService {


    public abstract ServiceEnum getServiceEnum();

    /**
     * IService的实现类全部注解了@Component
     * 当Spring容器启动时，实现类被spring组件化注入到spring容器中，
     * 此时当依赖注入之后会自动执行此注解了@PostConstruct的方法
     * 初始化Cashier的静态MAP
     */
    @PostConstruct
    public void init(){
        Cashier.map.put(this.getServiceEnum(),this);
    }
}
