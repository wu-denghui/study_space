package com.goodhealth.comm.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName RegexUtil
 * @Description 正则表达式工具类
 * @Author WDH
 * @Date 2019/9/2 9:50
 * @Version 1.0
 **/
public class RegexUtil {

/*    public static void main(String[] args){
        System.out.println(isContain("123大猫235",REGEX_ENGLISH));
        System.out.println(is("123235",REGEX_ENGLISH));
    }*/

    // 邮箱正则
    public static final String EMAIL = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
    // 手机号
    public static final String MOBILE = "1\\d{10}";
    // 固话
    public static final String PHONE = "^(\\+\\d{2}-)?0\\d{2,3}-\\d{7,8}$";
    // 支持带“-”格式的手机号
    public static final String MOBILE_2 = "1\\d{10}|1\\d{2}-\\d{4}-\\d{4}";
    // 手机号和电话正则表达式
    public static final String PHONE_AND_MOBILE = "(\\+86[\\s-]?)?(\\d{3,4}[\\s-]?\\d{3,4}[\\s-]?\\d{3,4})|(1\\d{10})|(([0,4,8]{3,4})-?)?\\d{7,10}(-?\\d{1,5})?";
    // 数字
    public static final String NUMERIC = "[0-9]+";
    // 英文
    public static final String ENGLISH = "[a-zA-Z]+";
    // 汉字
    public static final String CHINESE = "[\\u4e00-\\u9fa5]+$";
    // 网址
    public static final String URL = "^((http)|(https))://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
    // ip
    public static final String IP = "\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}";
    /**
     * 校验是否是固话
     * @param str
     * @return
     */
    public static boolean isPhone(String str){
        return is(str,PHONE);
    }

    /**
     * 校验是否邮箱
     * @param str
     * @return
     */
    public static boolean isEmail(String str){
        return is(str, EMAIL);
    }

    /**
     * 是否手机
     * @param str
     * @return
     */
    public static boolean isMobile(String str){
        return is(str, MOBILE);
    }

    /**
     * 判断是否为符合条件
     * @param str
     * @param regEx
     * @return
     */
    public static boolean is(String str, String regEx){
        // 编译正则表达式
        Pattern pattern = Pattern.compile("^"+regEx+"$");
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        return matcher.find();
    }



    /**
     * 判断是否包含
     * @param str
     * @param regEx
     * @return
     */
    public static boolean isContain(String str, String regEx){
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        return matcher.find();
    }


    /**
     * 查找  第一个符合的内容
     * @param str
     * @param regEx
     * @return
     */
    public static String find(String str, String regEx){
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            return matcher.group(0);
        }
        return null;
    }
}
