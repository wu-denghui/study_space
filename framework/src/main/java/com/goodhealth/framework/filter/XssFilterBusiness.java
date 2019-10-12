/*
 * Copyright by Deppon and the original author or authors.
 *
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Deppon from
 *
 *
 *      http://www.deppon.com
 *
 */
package com.goodhealth.framework.filter;


import com.goodhealth.comm.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * xss过滤器
 */
public class XssFilterBusiness{

    /**
     * 脚本过滤
     */
    private static List<Pattern> scriptPatternList = new ArrayList<>();

    /**
     * 字符替换，数组：0-原字符，1-替换字符
     */
    private static List<String[]> replaceValueList = new ArrayList<>();

    static {

        // 正则脚本过滤
        scriptPatternList.add(Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE));
        scriptPatternList.add(Pattern.compile("['\"]+\\w*\\s*on[a-z]+=", Pattern.CASE_INSENSITIVE));
        scriptPatternList.add(Pattern.compile("</script>", Pattern.CASE_INSENSITIVE));
        scriptPatternList.add(Pattern.compile("<script(.*?)>",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        scriptPatternList.add(Pattern.compile("eval\\((.*?)\\)",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        scriptPatternList.add(Pattern.compile("e­xpression\\((.*?)\\)",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        scriptPatternList.add(Pattern.compile("onload(.*?)=",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        scriptPatternList.add(Pattern.compile("vbscript[\r\n| | ]*:[\r\n| | ]*", Pattern.CASE_INSENSITIVE));
        scriptPatternList.add(Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE));

        // 特殊字符替换
        replaceValueList.add(new String[]{"\\\"","”"});
        replaceValueList.add(new String[]{"\\'","’"});
        replaceValueList.add(new String[]{"\\\'","’"});

    }

    /**
     * 过滤特殊字符
     */
    public static String filter(String value) {

        if(StringUtil.isBlank(value)){
            return value;
        }

        // 特殊字符替换
        for(String[] repValue : replaceValueList){
            value = value.replace(repValue[0], repValue[1]);
        }

        value = value.replaceAll("\0", "");

        // 删除 script 脚本
        for(Pattern pattern : scriptPatternList){
            value = pattern.matcher(value).replaceAll("");
        }

        StringBuffer result = new StringBuffer(value.length());
        for (int i = 0; i < value.length(); ++i) {
            switch (value.charAt(i)) {
                case '<':
                    result.append("＜");
                    break;
                case '>':
                    result.append("＞");
                    break;
                case '"':
                    result.append("\"");
                    break;
                case '\'':
                    result.append("'");
                    break;
                case '%':
                    result.append("%");
                    break;
                case ';':
                    result.append(";");
                    break;
                case '(':
                    result.append("(");
                    break;
                case ')':
                    result.append(")");
                    break;
                case '&':
                    result.append("&");
                    break;
                default:
                    result.append(value.charAt(i));
                    break;
            }
        }
        return result.toString();
    }

}
