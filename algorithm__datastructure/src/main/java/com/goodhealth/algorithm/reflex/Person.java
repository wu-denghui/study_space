package com.goodhealth.algorithm.reflex;


import java.util.Calendar;
import java.util.Date;

public class Person implements de {

    private String name;

    private Integer age;

    private boolean adult;

    public Person() {

    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    private static void staMethod(){
        System.out.println("这是一个静态方法");
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doSome() {
        System.out.println("实现接口中的方法");
    }



    @Override
    public String toString() {
        return "{" +
                "\"name\":\"" + name + '\"' +
                ",\"age\":" + age +
                '}';
    }
}
