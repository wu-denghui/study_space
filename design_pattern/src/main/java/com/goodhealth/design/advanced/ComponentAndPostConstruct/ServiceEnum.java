package com.goodhealth.design.advanced.ComponentAndPostConstruct;

public enum ServiceEnum {

    COLLECT_MONEY("collectmoney"),

    GIVECHANGE("givechange");

    /** 服务的类型 */
    private String type;

    private ServiceEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
