package com.goodhealth.comm.constant;

public interface GlobalConstants {

    long VALID_TIME = 15*60*1000;

    int EXPIRY = 60 * 15;

    int LONG_EXPIRY = 60*60*24;

    long REFRESH_VALID_TIME = 24*60*60*1000;

    byte[] SECRET = "gedwodiangasfdjsikolkjikolkijswe".getBytes();

    String ISS="MR_WDH";

    Integer COOKIES_MAX_AGE = 24*60*60;

    Integer PAGE_SIZE = 10;

    /**
     * http接口调用，默认超时时间（连接）
     */
    public static final int HTTP_CONNECT_TIMEOUT_DEFAULT = 3000;

    /**
     * http接口调用，默认超时时间（读取）
     */
    public static final int HTTP_READ_TIMEOUT_DEFAULT = 3000;
}
