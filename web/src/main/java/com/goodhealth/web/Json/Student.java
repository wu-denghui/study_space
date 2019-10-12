package com.goodhealth.web.Json;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.util.Date;

/**
 * @ClassName Student
 * @Description TODO  使用的是fastJson
 * @Author WDH
 * @Date 2019/8/15 8:10
 * @Version 1.0
 **/
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student{


    @JSONField(name = "id")
    int studentId;

    int age;

    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    Date birthday;

    String loginName;

    String realName;

    @JSONField(serialize = false,deserialize = false)
    String password;


}
