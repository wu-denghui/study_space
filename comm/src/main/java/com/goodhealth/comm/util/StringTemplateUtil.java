package com.goodhealth.comm.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: WDH
 * @Date: 2019/4/8 01:39
 * @Description:
 */
public class StringTemplateUtil {

    private static final Pattern MONEY_PATTERN =Pattern.compile("\\$\\{\\w+\\}");

/*    public static void main(String[] args){
        Map map = new HashMap();
        map.put("name", "张三");
        map.put("money", String.format("%.2f", 10.155));
        map.put("point", 10);
        String message = processTemplate("您好${name}，晚上好！您目前余额：${money}元，积分：${point}", map);
        System.out.println(message);
        //您好张三，晚上好！您目前余额：10.16元，积分：10
    }*/
    public static String fillTemplate(String template, Map<String, Object> params){
        if (StringUtil.isBlank(template)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Matcher matcher =MONEY_PATTERN.matcher(template);
        while (matcher.find()) {
            String param = matcher.group();
            Object value = params.get(param.substring(2, param.length() - 1));
            // 把匹配到的内容替换为replaceContext，并且把从上次替换的位置到这次替换位置之间的字符串也拿到，
            // 然后，加上这次替换后的结果一起追加到StringBuffer里
            matcher.appendReplacement(sb, value==null ? "" : value.toString());
        }
        // sb是一个StringBuffer，这个方法是把最后一次匹配到内容之后的字符串追加到StringBuffer中。
        matcher.appendTail(sb);
        return sb.toString();
    }


/**
 只替换第一个：
 if (matcher.find()){
 matcher.appendReplacement(sb, replaceContext);
 }
 matcher.appendTail(sb);
 替换所有：
 while (matcher.find()){
 matcher.appendReplacement(sb, replaceContext);
 }
 matcher.appendTail(sb);
 */
}
