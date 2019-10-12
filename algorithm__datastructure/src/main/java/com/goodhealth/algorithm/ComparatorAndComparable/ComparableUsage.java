package com.goodhealth.algorithm.ComparatorAndComparable;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName ComparableUsage
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/6 10:43
 * @Version 1.0
 **/
@Data
public class ComparableUsage implements Comparable<ComparableUsage> {

    public static void main(String[] args){
        System.out.println(new ComparableUsage(18,"xw").compareTo(new ComparableUsage(19,"dw")));
        // 排序
        List<ComparableUsage> list = new ArrayList<>();
        Collections.sort(list);
    }
    private Integer age;

    private String name;



    public ComparableUsage(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(ComparableUsage o) {
        if (o.age < this.age){
            return 1;
        }
        if (o.age > this.age){
            return -1;
        }
        if (o.age.equals(this.age)){
            if (this.name.hashCode() > o.name.hashCode()){
                return 1;
            }
            if (this.name.hashCode() < o.name.hashCode()){
                return -1;
            }
        }
        return 0;
    }

}
