package com.goodhealth.comm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


public class FeatureUtil {

    public static String getFeatureValue(String feature,String name) {
        //json
        if (ObjectUtils.isEmpty(feature)) {
            return null;
        }
        JSONObject jsonObject = JSON.parseObject(feature);
        if (!ObjectUtils.isEmpty(jsonObject.get(name))) {
            return jsonObject.getString(name);
        }
        return null;
    }

    public static String addFeatureValue(String feature,String name,Object value) {
        //json
        return addFeatureValue(feature,name,JSON.toJSONString(value));
    }

    public static String addFeatureValue(String feature,String name,String value) {
        //json

        JSONObject jsonObject = ObjectUtils.isEmpty(feature) ? new JSONObject() : JSON.parseObject(feature) ;
        if (!StringUtils.isEmpty(value)) {
            jsonObject.put(name,value);
        }

        return jsonObject.toJSONString();
    }
}
