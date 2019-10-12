package com.goodhealth.design.advanced.ThreadPoolStyle;

public enum ThreadNamePrefixEnum {

    CREATE_BILL_THREAD_PREFIX("createBillNumberThread_"),
    CREATE_WAY_THREAD_PREFIX("createWayNumberThread_"),
    PRINT_ORDER_THREAD_PREFIX("printOrderNumberThread_"),
    SEND_MESSAGE_THREAD_PREFIX("sendMessageNumberThread_")
    ;
    /**
     * 工作线程命名前缀
     */
    private String namePrefix;

    ThreadNamePrefixEnum(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }
}
