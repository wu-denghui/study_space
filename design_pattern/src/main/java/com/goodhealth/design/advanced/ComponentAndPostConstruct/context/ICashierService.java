package com.goodhealth.design.advanced.ComponentAndPostConstruct.context;

import com.goodhealth.design.advanced.ComponentAndPostConstruct.Service.IService;
import com.goodhealth.design.advanced.ComponentAndPostConstruct.ServiceEnum;

public interface ICashierService {

    IService getService(ServiceEnum serviceEnum);
}
