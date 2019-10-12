package com.goodhealth.framework.entity.user;

/**
 * 用户客户端信息
 */
public class UserClientInfoEntity {

	/**
	 * 客户端ip
	 */
	private String clientIp;

	/**
	 * 标识客户使用的操作系统及版本、CPU 类型、浏览器及版本、浏览器渲染引擎、浏览器语言、浏览器插件等
	 */
	private String userAgent;


	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

}
