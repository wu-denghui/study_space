package com.goodhealth.design.advanced.BusinessAndScene;

public enum ActionEnum {

    AFTERNOON("下午"),

    NOONDAY("中午"),

    MORINING("早上")
    ;

    ActionEnum(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
