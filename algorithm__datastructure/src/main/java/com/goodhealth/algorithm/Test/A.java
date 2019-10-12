/**
 * 
 */
package com.goodhealth.algorithm.Test;


import com.auth0.jwt.internal.org.apache.commons.codec.binary.Base64;

/**
 * @author 24663
 * @date 2018年12月24日
 * @Description
 */
public class A {
	public static void main(String[] args) {
		System.out.println(new String(Base64.encodeBase64("渠道系统研发部".getBytes())));
		System.out.println(new String(Base64.decodeBase64("5rig6YGT57O757uf56CU5Y+R6YOo")));
	}
}
