package com.goodhealth.web.Timer;

import com.goodhealth.comm.util.DateUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description
 * @Author WDH
 * @Date 2019/9/28 10:51
 **/
@Component
public class TimeWork {

    public void task(){
        System.out.println("现在是北京时间："+ DateUtils.formatDateTime(new Date(), DateUtils.YYYY_MM_DD_HH_MI_SS));
    }
}
