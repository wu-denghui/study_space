package com.goodhealth.algorithm.NKExercise;

import java.math.BigDecimal;

/**
 *   使用bigDecimal精确计算浮点型
 * @author w7
 *
java.math.BigDecimal。BigDecimal一共有4个够造方法，通常建议优先使用String构造方法,让我先来看看其中的两种用法：
第一种：BigDecimal(double val)
Translates a double into a BigDecimal.

第二种：BigDecimal(String val)
Translates the String repre sentation of a BigDecimal into a BigDecimal.

使用BigDecimal要用String来够造，要做一个加法运算，需要先将两个浮点数转为String，然后够造成BigDecimal，在其中一个上调用add方法，传入另一个作为参数，然后把运算的结果（BigDecimal）再转换为浮点数。


public static double add(double v1,double v2) +
public static double sub(double v1,double v2)-
public static double mul(double v1,double v2)*
public static double div(double v1,double v2)/
public static double div(double v1,double v2,int scale)
public static double round(double v,int scale)
 */
public class Bigdecimal {

	public static void main(String[] args) {
       float f=123.456f;
       long l=123456;
       double d=123.45;
       String s="123.456";
       BigDecimal bs= new BigDecimal(s);
       BigDecimal bd=new BigDecimal(d);
       BigDecimal bl=new BigDecimal(l);
	}

}
