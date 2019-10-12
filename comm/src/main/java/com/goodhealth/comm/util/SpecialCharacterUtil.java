package com.goodhealth.comm.util;

/**
 * @ClassName SpecialCharacterUtil
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/2 9:48
 * @Version 1.0
 **/
public class SpecialCharacterUtil {
    public static final String SPECIALCHARACTERS[] = {";", "：", ":", "。", "！"," ", "，", ",", "\n", "\t", "\u00A0"};

    public static final String SPECIALWORDS[] = {"公司地址", "收货地址", "退货地址", "收件地址", "电话号码", "联系方式",
            "手机号码", "固定电话", "办公电话", "收货人", "收件人", "联系人", "手机号", "联系", "姓名", "电话", "手机", "地址"};


    /**
     * 特殊字符过滤
     * @param characters
     * @return
     */
    public static final String executeCharacters(String characters){
        if(StringUtil.isBlank(characters)){
            return characters;
        }
        for(String special : SPECIALCHARACTERS){
            while(characters.contains(special)){
                characters = characters.replaceAll(special, "");
            }
        }
        return characters;
    }

    /**
     * 特殊文字过滤
     * @param characters
     * @return
     */
    public static final String executeWords(String characters){
        if(StringUtil.isBlank(characters)){
            return characters;
        }
        for(String special : SPECIALWORDS){
            while(characters.contains(special)){
                characters = characters.replaceAll(special, "");
            }
        }
        return characters;
    }
}
