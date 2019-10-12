package com.goodhealth.comm.util;

import java.util.UUID;

public class UUIDUtil {
    /**
     *
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
