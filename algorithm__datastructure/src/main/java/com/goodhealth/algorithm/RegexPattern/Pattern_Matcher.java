package com.goodhealth.algorithm.RegexPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Pattern_Matcher
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/28 17:06
 * @Version 1.0
 **/
public class Pattern_Matcher {
    final static String regex = "\\d+";
    final static Pattern pattern =  Pattern.compile(regex);

    public static void main(String[] args){
        Matcher m = pattern.matcher("aaa2223bb55");
        m.find();       //对字符串进行匹配,匹配到的字符串可以在任何位置.   匹配2223 返回true
        m.start();      //返回匹配到的子字符串在字符串中的索引位置.  返回3
        m.end();        //返回匹配到的子字符串的最后一个字符在字符串中的索引位置  返回的是2223后的索引号 7
        m.group();      //返回匹配到的子字符串  返回2223
        m.groupCount(); //用于返回有多少组. 返回 2
        Matcher m2=pattern.matcher("2223bb");
        m.lookingAt();   //对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true  匹配2223
        m.start();       //返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0
        m.end();         //返回4
        m.group();       //返回2223

        Matcher m3=pattern.matcher("2223bb");
        m.matches();   //对整个字符串进行匹配,只有整个字符串都匹配了才返回true 匹配整个字符串
        m.start();     //返回0,原因相信大家也清楚了
        m.end();       //返回6,原因相信大家也清楚了,因为matches()需要匹配所有字符串
        m.group();     //返回2223bb
    }

    public static String intoStringBuffer(String template){
        Matcher m = Pattern.compile("\\$\\{\\w+\\}").matcher(template);
        StringBuffer sb = new StringBuffer();

        // 将目标字符串里与既有模式相匹配的子串全部替换为指定的字符串。
        m.replaceAll("xxoo");

        // 将目标字符串里第一个与既有模式相匹配的子串替换为指定的字符串。
        m.replaceFirst("xxoo");

        /**
         * 将当前匹配子串替换为指定字符串，
         * 并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里，
         * 而appendTail(StringBuffer sb)方法则将最后一次匹配工作后剩余的字符串添加到一个StringBuffer对象里。
         */
        while (m.find()) {
            String param = m.group();
            m.appendReplacement(sb, "\""+param+"\"");
        }
        m.appendTail(sb);
        return sb.toString();
    }
}
