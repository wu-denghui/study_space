package com.goodhealth.web.Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName Test.JsonCompare
 * @Description jackson 和  阿里系fastJson 的比较
 * @Author WDH
 * @Date 2019/8/14 19:02
 * @Version 1.0
 **/
public class JsonCompare {

    public static void main(String[] args){
        String jsonString = "[{\"age\":15,\"birthday\":\"2016-10-11\",\"loginName\":\"xiaowang\",\"password\":\"123456\",\"realName\":\"小王\",\"studentId\":1},{\"age\":15,\"birthday\":\"2016-10-11\",\"loginName\":\"xiaozhang\",\"password\":\"123456\",\"realName\":\"小张\",\"studentId\":2}]";
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,15,new Date(),"xiaowang","小王","123456"));
        students.add(new Student(2,15,new Date(),"xiaozhang","小张","123456"));
          beanCollectionToJsonString(students);
        // jsonStringToBean();
        //  beanToJsonString(new Student(1,15,new Date(),"xiaowang","小王","123456"));
//         jsonStringToBeanList(jsonString);
    }

    /*
     * @Author WDH
     * @Description TODO  javabean转换为json字符串
     * @Param
     * @return
    **/
    public static void  beanToJsonString(Object object){
        // fastJson 将对象转化为json字符串
        String jsonString = JSONObject.toJSONString(object);
        jsonString = JSON.toJSONString(object);
        System.out.println(jsonString);

        // jackson 将对象转化为字符串
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Teacher teacher = new Teacher(1,15,new Date(),"xiaowang","小王","123456");
            jsonString = objectMapper.writeValueAsString(teacher);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author WDH
     * @Description TODO 集合对象转换为json字符串
     * @Param 
     * @return 
    **/
    public static void  beanCollectionToJsonString(List<Student> objects){
        // fastJson 集合对象转换为json字符串
        String jsonString = JSON.toJSONString(objects);
        System.out.println(jsonString);
        jsonString = JSONObject.toJSONString(objects);
        System.out.println(jsonString);
        jsonString = JSONArray.toJSONString(objects);
        System.out.println(jsonString);
        // jackson 集合对象转换为json字符串
//        ObjectMapper objectMapper = new ObjectMapper();
        ObjectMapper objectMapper = JacksonObjectMapperSingle.getInstance();
        try {
            jsonString = objectMapper.writeValueAsString(objects);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /*
     * @Author WDH
     * @Description TODO  json字符串转换为javabean对象
     * @Param
     * @return
    **/
    public static void jsonStringToBean(String jsonString){
        // fastJson 将json字符串转换为javabean对象
        Student student = JSONObject.parseObject(jsonString, Student.class);
        student = JSONObject.parseObject(jsonString, new  TypeReference<Student>(){});

        // jackson 将json字符串转换为javabean对象
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            student = objectMapper.readValue(jsonString, Student.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author WDH
     * @Description TODO json数组字符串类型转换为集合
     * @Param
     * @return
    **/
    public static void jsonStringToBeanList(String jsonString){
        //  fastJson   将json数组字符串类型转换为List集合
        List<Student>  students = JSONArray.parseArray(jsonString, Student.class);
        System.out.println(students+"1");
        //  students = (List<Student>) JSONArray.parseObject(jsonString, new TypeReference<Student>(){});
        //  System.out.println(students+"2");
        students = JSONObject.parseArray(jsonString, Student.class);
        System.out.println(students);

        // jackson 将json数组字符串类型转换为List集合
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Student.class);
        //  如果是Map类型
        //  JavaType javaType =  mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, String.class);
        try {
        // HashMap<String, String> students = new HashMap<>();
            students = mapper.readValue(jsonString, javaType);
            System.out.println(students);
            students =mapper.readValue(jsonString, List.class);
            System.out.println(students);
            students = mapper.readValue(jsonString, new com.fasterxml.jackson.core.type.TypeReference<List<Student>>(){});
            System.out.println(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Author WDH
     * @Description TODO json数组字符串类型转换为集合
     * @Param
     * @return
    **/
    public static void jsonStringToBeanMap(String jsonString){
//         fastJson   将json数组字符串类型转换为List集合
        // jackson 将json数组字符串类型转换为Map集合
        ObjectMapper mapper = new ObjectMapper();
//        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Student.class);
        // 如果是Map类型
        JavaType javaType =  mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, Student.class);
        try {
            HashMap<String, Student> students = new HashMap<>();
            students = mapper.readValue(jsonString, javaType);
            System.out.println(students);
//            students =mapper.readValue(jsonString, Map.class);
//            System.out.println(students);
            students = mapper.readValue(jsonString, new com.fasterxml.jackson.core.type.TypeReference<Map<String,Student>>(){});
            System.out.println(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
