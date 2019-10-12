package com.goodhealth.comm.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @ClassName CookiesUtil
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/5 11:34
 * @Version 1.0
 **/
public class CookiesUtil {
    /**
     * 获取所有cookie
     * @return
     */
    public static Cookie[] readAllCookie(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest().getCookies();
    }

    /**
     * 读取Cookie中的值
     * @param key
     * @return
     */
    public static String readCookie(String key) {
        Cookie[] cookie = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest().getCookies();
        if (cookie == null) {
            return null;
        }
        for (int i = 0; i < cookie.length; i++) {
            if (cookie[i].getName().equals(key)) {
                // 解码
                String value = cookie[i].getValue();
                try {
                    if (StringUtil.isNotEmpty(value)) {
                        value = URLDecoder.decode(value, "UTF-8");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return null;
                }
                return value;
            }
        }
        return null;
    }


    /**
     * 写入cookie
     * @param key
     * @param value
     * @param maxAge
     * @param isHttpOnly
     */
    public static void writeCookie(String key, String value, int maxAge, boolean isHttpOnly) {
        Cookie cookie;
        try {
            if (StringUtil.isNotEmpty(key)) {
                value = URLEncoder.encode(value == null ? "" : value, "utf-8");
                cookie = new Cookie(key, value);
                if (maxAge != 0) {
                    cookie.setMaxAge(maxAge);
                }
                cookie.setPath("/");
                cookie.setHttpOnly(isHttpOnly);
                ((ServletRequestAttributes) RequestContextHolder
                        .getRequestAttributes()).getResponse()
                        .addCookie(cookie);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对writeCookie的重载，增加domain、isSecure参数,用于跨域登陆
     *
     * @param key
     * @param value
     * @param maxAge
     * @param domain
     * @param isSecure
     * @param isHttpOnly
     */
    public static void writeCookie(String key, String value, int maxAge,
                            String domain, boolean isSecure, boolean isHttpOnly) {
        Cookie cookie;
        try {
            if (StringUtil.isNotEmpty(key)) {
                value = URLEncoder.encode(value == null ? "" : value, "utf-8");
                cookie = new Cookie(key, value);
                if (maxAge != 0) {
                    cookie.setMaxAge(maxAge);
                }
                cookie.setPath("/");
                cookie.setDomain(domain);
                cookie.setSecure(isSecure);
                cookie.setHttpOnly(isHttpOnly);
                ((ServletRequestAttributes) RequestContextHolder
                        .getRequestAttributes()).getResponse()
                        .addCookie(cookie);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 清空cookies
     */
    public static void clearCookie(String key) {
        writeCookie(key, "", 0, false);
    }

    /**
     * 清空cookie方法重载，增加domain、isSecure参数,用于登出
     */
    public static void clearCookie(String key, String domain) {
        writeCookie(key, "", 0, false);
        writeCookie(key, "", 0, domain, false, false);
    }
}
