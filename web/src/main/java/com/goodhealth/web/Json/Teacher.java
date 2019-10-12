package com.goodhealth.web.Json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Teacher
 * @Description TODO  使用的是JackJson
 * @Author WDH
 * @Date 2019/8/15 8:14
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
// @JsonIgnoreProperties(value = {"password","realName"}) 使用在类上 注明的属性都不参与序列化和反序列化
// @JsonInclude(JsonInclude.Include.NON_NULL)  属性为null不参与序列化。
// @JsonInclude(JsonInclude.Include.NON_EMPTY)  属性为空或者null都不参与序列化。
// @JsonIgnoreType 当其他类中含有Teacher这个属性时，Teacher属性将不会参与序列化或反序列化
public class Teacher {

    @JsonProperty(value = "id")
    Integer teacherId;

    Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    Date birthday;

    String loginName;

    String realName;

    @JsonIgnore
    String password;
}
