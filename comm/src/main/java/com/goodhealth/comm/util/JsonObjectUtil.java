package com.goodhealth.comm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


public class JsonObjectUtil {

/*    public static void main(String[] args){
        String json1 = "{Student1:{name:'王二小',age:15},Student2:{name:'李斯',age:99}}";
        String json2 = "{name:'李斯',age:99}";
        System.out.println(getObjectValue(json1, "age"));
        System.out.println(addStringValue(json2, "gender","1"));
        System.out.println(addStringValue("", "gender","1"));
        System.out.println(addObjectValue(json2, "kids",new Student(1,"里斯",12)));
        System.out.println(json2);
        System.out.println(getObjectValue(addObjectValue(json2, "kids",new Student(1,"里斯",12)), "kids"));
    }*/


    public static String getObjectValue(String json,String key) {
        //json
        if (ObjectUtils.isEmpty(json)) {
            return null;
        }
        JSONObject jsonObject = JSON.parseObject(json);
        if (!ObjectUtils.isEmpty(jsonObject.get(key))) {
            return jsonObject.getString(key);
        }
        return null;
    }

    public static String addObjectValue(String json, String key,Object value) {
        //json
        return addStringValue(json,key,JSON.toJSONString(value));
    }


    public static String addStringValue(String json, String key, String value) {
        //json
        JSONObject jsonObject = ObjectUtils.isEmpty(json) ? new JSONObject() : JSON.parseObject(json) ;
        if (!StringUtils.isEmpty(value)) {
            jsonObject.put(key,value);
        }
        return jsonObject.toJSONString();
    }
}

