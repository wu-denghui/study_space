package com.goodhealth.algorithm.Jackson_FastJson;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/15 8:14
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"password","realName"})
//@JsonInclude(JsonInclude.Include.NON_NULL)   //属性为null不参与序列化。
@JsonInclude(JsonInclude.Include.NON_EMPTY) // 属性为空或者null都不参与序列化。
@JsonIgnoreType //当其他类中含有Teacher这个属性时，Teacher属性将不会参与序列化或反序列化
public class Teacher {

    @JsonProperty(value = "id")
    private Integer teacherId;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date birthday;

    // 不参与序列化
    @JsonIgnore
    private String password;

    private String loginName;

    private String realName;

    private Student student;

    public Teacher(Integer teacherId, Integer age, Date birthday, String loginName, String realName, String password) {
        this.teacherId = teacherId;
        this.age = age;
        this.birthday = birthday;
        this.loginName = loginName;
        this.realName = realName;
        this.password = password;
    }

    public Teacher(String loginName, int age){
        this.loginName = loginName;
        this.age = age;
    }
}
