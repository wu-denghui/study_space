package com.goodhealth.algorithm.reflex;

import java.util.function.Consumer;

public interface de {

    public default void jdk8DefaultMethod(){
        System.out.println("JDK1.8之后在接口中新增default方法，默认为public ");
    }
    public static void jdk8StaticMethod(){
        System.out.println("JDK1.8之后接口中可以有静态方法，默认为public");
    }
    public abstract void doSome();

}
