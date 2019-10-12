package com.goodhealth.algorithm.lambda;

import com.goodhealth.algorithm.Jackson_FastJson.Student;
import com.goodhealth.algorithm.Jackson_FastJson.Teacher;

import java.util.Optional;

/**
 * @Description
 * @Author WDH
 * @Date 2019/9/20 16:44
 **/
public class OptionalUsage {

    public static void main(String[] args){
        Integer i = null;
        Integer in = 12;
        /**
         * Optional<T> 包含有可选值的包装类  包含的对象可能是空也可能是一个值
         * 用于简化处理NPE的处理过程
         */
        /** 构造Optional */
        // 构建一个包含空值的Optional 调用会触发NPE
        Optional<Integer> emptyValues = Optional.empty();
        //  emptyValues.get(); NPE
        // 构建一个一定包含值得Optional
        Optional<Integer> sureValues = Optional.of(in);
        sureValues.get();
        // 构建一个可能为空也可能是值的Optional
        Optional<Integer> noSureValues = Optional.ofNullable(i);
        // noSureValues.get();  NPE
        noSureValues.isPresent(); //判断是否为空
        noSureValues.ifPresent(System.out::println); // 不为空时才执行里面lambda
        // 为空时返回入参   不为空返回原值
        noSureValues.orElse(newIn());
        // 为空时执行lambda  不为空时无操作
        noSureValues.orElseGet(()-> newIn());
        //  noSureValues.orElseThrow(()-> new IOException());  为空时抛出指定的异常
        // map  map() 对值应用(调用)作为参数的函数，然后将返回的值包装在 Optional 中
        Teacher student = new Teacher("xx",18);
        System.out.println(Optional.ofNullable(student).map(Teacher::getStudent).orElse(new Student("bs")).getLoginName());
        // filter() 接受一个 Predicate 参数，返回测试结果为 true 的值。
        // 如果测试结果为 false，会返回一个空的 Optional
        Optional.ofNullable(120).filter(t->t>20).orElse(20);
    }







    public static Integer newIn(){
        return  new Integer(10);
    }
}
