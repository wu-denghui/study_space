package com.goodhealth.framework.entity.request;

import com.goodhealth.framework.entity.DTO;

/**
 * @Description
 * @Author WDH
 * @Date 2019/9/21 15:59
 **/
public class BaseRequest extends DTO {

    /**
     * 系统编码
     */
    protected String sysCode;

    /**
     * 系统编码
     * @param sysCode
     */
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    /**
     * 系统编码
     */
    public String getSysCode() {
        return this.sysCode;
    }

    @Override
    public String toString() {
        return "BaseRequest{" +
                "sysCode='" + sysCode + '\'' +
                '}';
    }
}
