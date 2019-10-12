/*
 * Copyright by Deppon and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Deppon from
 *
 *
 *      http://www.deppon.com
 *
 */
package com.goodhealth.framework.session;

import com.alibaba.fastjson.JSONObject;
import com.goodhealth.comm.util.StringUtil;
import com.goodhealth.comm.util.restful.HttpUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @描述：session 信息
 */
public class SessionInfo implements Serializable {

	private static final long serialVersionUID = 6029657754584291179L;

	/**
	 * 创建时间
	 */
	private long createtime;

	/**
	 * 最后使用时间
	 */
	private long lastusetime;

	/**
	 * session过期时间
	 */
	private int timeout;

	/**
	 * 客户端ip
	 */
	private String clientIp;

	/**
	 * SessionInfo
	 */
	private SessionInfo(){

	}

	/**
	 * 创建sessionInfo
	 * @param request
	 * @return
	 */
	static SessionInfo create(HttpServletRequest request) {
		SessionInfo sessionInfo = null;
		try{
			sessionInfo = new SessionInfo();
			// 客户端IP
			sessionInfo.setClientIp(HttpUtil.getUserClientIp(request));
			// session创建时间
			sessionInfo.setCreatetime(System.currentTimeMillis());
			// 最后更新时间
			sessionInfo.setLastusetime(System.currentTimeMillis());
			// session过期时间
			int timeout = 1000;
			String timeoutOfConfig = "framework.session.timeout";
			if(StringUtil.isNotEmpty(timeoutOfConfig)){
				timeout = Integer.valueOf(timeoutOfConfig);
			}
			sessionInfo.setTimeout(timeout);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sessionInfo;
	}
	
	/**
	 * json数据转换为SessionInfo
	 * @param
	 * @param json
	 */
	static SessionInfo conversionFromJson(String json){
		SessionInfo sessionInfo = null;
		try{
			sessionInfo = JSONObject.parseObject(json, SessionInfo.class);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sessionInfo;
	}
	
	/**
	 * 是否过期
	 * @return
	 */
	boolean isTimeout(){
		long t1 = System.currentTimeMillis()-this.lastusetime;
		long t2 = ((long)this.timeout) * 1000;
		if(t1>t2){
			return true;
		}else{
			return false;
		}
	}

	public long getCreatetime() {
		return createtime;
	}

	public void setCreatetime(long createtime) {
		this.createtime = createtime;
	}

	public long getLastusetime() {
		return lastusetime;
	}

	public void setLastusetime(long lastusetime) {
		this.lastusetime = lastusetime;
	}
	
	public void updateLastUseTime() {
		this.lastusetime = System.currentTimeMillis();
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

}
