package com.goodhealth.algorithm.Jackson_FastJson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.util.Date;

/**
 * @ClassName Student
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/15 8:10
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true) 当有继承关系的时加上这个注解 使重写equals和hashcode方法的时候加上父类的属性
public class Student{


    public Student(){

    }

    public Student(String loginName, int age){
        this.loginName = loginName;
        this.age = age;
    }

    public Student(String loginName){
        this.loginName = loginName;
    }


    @JSONField(name = "id")
    private Integer studentId;

    private Integer age;

    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date birthday;

    @JSONField(deserialize = false)
    private String loginName;

    private String realName;

    @JSONField(serialize = false)
    private String password;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
