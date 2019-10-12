package com.goodhealth.comm.util;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.goodhealth.comm.constant.GlobalEnum;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class StringUtil extends StringUtils {

    private static final String SPLIT_CHAR_DOUHAO = ",";

    /**
     * 判断数组是否为空
     * @param strArray
     * @return
     */
    public static boolean isNull(String[] strArray){
        return strArray == null || strArray.length<1;
    }

    /**
     * 判断数组是否为空
     * @param strArray
     * @return
     */
    public static boolean isNotNull(String[] strArray){
        return !isNull(strArray);
    }

    /**
     * 字符串正则比对
     * @param param
     * @param regEx
     * @return
     */
    public static Boolean isMatch(String param, String regEx) {
        //如果待验证字符串为空，则返回false
        if(isEmpty(param)) {
            return false;
        }
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(param);
        // 字符串是否与正则表达式相匹配
        return matcher.matches();
    }

    /**
     * 判断不是一个空字符串 且不是null字符串
     * @param param 待验字符串
     * @return
     */
    public static Boolean isNotNullString(String param) {
        return !isBlank(param) && !"null".equals(param);
    }

    /**
     * 根据一个字符串判断是星期几
     * @param param
     * @return
     */
    public static GlobalEnum.WeekDayEnum parserString2WeekDay(String param) {
        if(isEmpty(param)) {
            return null;
        }
        for (GlobalEnum.WeekDayEnum value : GlobalEnum.WeekDayEnum.values()) {
            if(value.getName().equals(param)
                    || value.getDesc().equals(param) || Integer.toString(value.getCode()).equals(param)) {
                return value;
            }
        }
        if("一".equals(param)) {
            return GlobalEnum.WeekDayEnum.monday;
        }
        if("二".equals(param)) {
            return GlobalEnum.WeekDayEnum.tuesday;
        }
        if("三".equals(param)) {
            return GlobalEnum.WeekDayEnum.wednesday;
        }
        if("四".equals(param)) {
            return GlobalEnum.WeekDayEnum.thursday;
        }
        if("五".equals(param)) {
            return GlobalEnum.WeekDayEnum.friday;
        }
        if("六".equals(param)) {
            return GlobalEnum.WeekDayEnum.saturday;
        }
        if("七".equals(param)) {
            return GlobalEnum.WeekDayEnum.sunday;
        }
        if("星期日".equals(param)) {
            return GlobalEnum.WeekDayEnum.sunday;
        }
        return null;
    }

    /**
     * 判断一个字符串数组是否包含某个字符串
     * @param strs
     * @param key
     * @return
     */
    public static boolean isStringArrayContainsKey(String [] strs, String key) {
        if(strs == null || strs.length < 1) {
            return false;
        }
        if(isEmpty(key)) {
            return false;
        }
        for (String str : strs) {
            if(key.equals(str)) {
                return true;
            }
        }
        return false;
    }


    public static String addIds(String value,Integer... ids) {
        String retValue = rmIds(value,ids);
        String idsValue = Joiner.on(SPLIT_CHAR_DOUHAO).join(ids) + SPLIT_CHAR_DOUHAO;
        return isBlank(retValue) ? SPLIT_CHAR_DOUHAO + idsValue : retValue + idsValue;
    }


    public static String rmIds(String value,Integer... ids) {
        for (Integer id : ids) {
            String idValue = MessageFormat.format("{0}{1}{2}",SPLIT_CHAR_DOUHAO,id,SPLIT_CHAR_DOUHAO);
            if (value.contains(idValue)) {
                value = value.replaceAll(idValue,SPLIT_CHAR_DOUHAO);
            }
        }
        return value;
    }

    public static List<Integer> getIdList(String ids) {
        if (StringUtil.isBlank(ids)) {
            return Lists.newArrayList();
        }
        List<Integer> idList = Lists.newArrayList(Arrays.stream(",1,2,3,".split(",")).map(e -> {
            if (StringUtils.isNotBlank(e)) {
                return Integer.parseInt(e);
            }
            return null;
        }).filter(e -> null != e).collect(Collectors.toList()));
        return idList;
    }

}
