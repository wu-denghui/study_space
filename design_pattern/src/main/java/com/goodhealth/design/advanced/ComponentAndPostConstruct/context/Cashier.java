package com.goodhealth.design.advanced.ComponentAndPostConstruct.context;

import com.goodhealth.design.advanced.ComponentAndPostConstruct.Service.IService;
import com.goodhealth.design.advanced.ComponentAndPostConstruct.ServiceEnum;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Cashier
 * @Description 收银台
 * @Author WDH
 * @Date 2019/9/4 21:39
 * @Version 1.0
 **/
@Service
public class Cashier implements ICashierService {

    public static final Map<ServiceEnum, IService> map = new HashMap<>(2);

    @Override
    public IService getService(ServiceEnum serviceEnum){
        return map.get(serviceEnum);
    }

}
