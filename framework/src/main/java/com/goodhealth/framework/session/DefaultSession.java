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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.goodhealth.comm.util.CookiesUtil;
import com.goodhealth.comm.util.SpringBeanUtil;
import com.goodhealth.comm.util.StringUtil;
import com.goodhealth.framework.entity.user.IUser;
import com.goodhealth.framework.entity.user.UserContextEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.goodhealth.comm.util.redis.RedisService;
import com.goodhealth.comm.util.restful.HttpUtil;
import com.goodhealth.comm.util.token.JwtUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 无状态session
 */
public class DefaultSession {

	private Logger LoggerUtil = LoggerFactory.getLogger(this.getClass());

	public static  final String  TOKEN = "token";

	private HttpServletRequest request;
	private String token;
	private SessionInfo sessionInfo;

	/**
	 * 当前浏览器session
	 * @param
	 */
	DefaultSession() {
	    // 获取当前request
		this.request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		// 读取token
		this.readToken();
		if (StringUtil.isNotEmpty(this.token)) {
			this.current();
		}
		if(!this.active()){
		    // session信息无效 创建新的
			this.create();
		}
		//重置session过期时间
		this.resetTimeout();
	}

	/**
	 * 读取token
	 */
	void readToken(){
		if(StringUtil.isBlank(this.token)) {
			this.token = this.request.getHeader(TOKEN);
		}
		if(StringUtil.isBlank(this.token)){
			this.token = this.request.getHeader(TOKEN);
		}
		// 请求头中找不到时去cookie中寻找
		if(StringUtil.isBlank(this.token)) {
			this.token = CookiesUtil.readCookie(TOKEN);
		}
		if (StringUtil.isBlank(this.token)) {
			this.token = CookiesUtil.readCookie(TOKEN);
		}
	}
	
	/**
	 * 创建session
	 *
	 */
	void create() {
		try{
			String ip = HttpUtil.getUserClientIp(request);
			// 生成token
			this.token = JwtUtil.generateTonken();
			LoggerUtil.debug("=========================================\r\n create session token:"+token);
			// 创建sessionInfo
			this.sessionInfo = SessionInfo.create(request);
			// 缓存操作
			this.getRedisService().hset(getHashKeyOfSession(), "key", JSON.toJSONString(this.sessionInfo));
		}catch (Exception e) {
			LoggerUtil.error("ecosession init error", e);
		}
	}

	/**
	 *  获取session信息解析成SessionInfo
	 */
	void current(){
		try{
			if(this.getRedisService().hexists(getHashKeyOfSession(), "key")){
				//缓存中获取session信息
				String sessionInfoJson = this.getRedisService().hget(getHashKeyOfSession(), "key");
				// 从缓存中解析当前sessionInfo
				this.sessionInfo = SessionInfo.conversionFromJson(sessionInfoJson);
			}
		}catch (Exception e) {
			LoggerUtil.error("session init error", e);
		}
	}

	/**
	 * 重置token
	 */
	public void resetToken(){
		try{
			// 当前key
			String oldkey = getHashKeyOfSession();
			// 重新生成token
			this.token = JwtUtil.generateTonken();
			// 新key
			String newkey = getHashKeyOfSession();
			// 重命名eco_session缓存key
			this.getRedisService().rename(oldkey, newkey);
			// 将token写入cookie
			CookiesUtil.writeCookie(TOKEN, this.token, this.sessionInfo.getTimeout(), true);
		}catch (Exception e) {
			LoggerUtil.error("ecosession restToken error", e);
		}
	}

	/**
	 * 是否可用  SessionInfo存在并且有效
	 * @return
	 */
	public boolean active(){
		try{
			if(this.sessionInfo==null){
				return false;
			}
			// 是否session过期
			if(!sessionInfo.isTimeout()){
				return true;
			}
		}catch (Exception e) {
			LoggerUtil.error("ecosession active method error", e);
		}
		return false;
	}
	
	/**
	 * 重置session过期时间
	 * @return
	 */
	public void resetTimeout(){
		this.resetTimeout(this.sessionInfo.getTimeout());
	}
	
	/**
	 * 重置session过期时间
	 * @return
	 */
	public void resetTimeout(int timeout){
		//写入cookie
		CookiesUtil.writeCookie(TOKEN, this.token, timeout, true);
		// 设置sessionInfo超时时间
		this.sessionInfo.setTimeout(timeout);
		// 设置最后使用时间为当前时间
		this.sessionInfo.updateLastUseTime();
		// 修改缓存中 session 信息
		if(this.getRedisService().hexists(getHashKeyOfSession(), "key")){
			this.getRedisService().hset(getHashKeyOfSession(), "key", JSON.toJSONString(this.sessionInfo));
		}
		// 重设缓存信息的过期时间
		this.getRedisService().expire(getHashKeyOfSession(), timeout);
	}

	/**
	 * 获取session属性
	 * @param key
	 * @return
	 */
	public String get(String key){
		return (String) this.getRedisService().hget(getHashKeyOfSession(), key);
	}
	
	/**
	 * 设置session属性
	 * @param key
	 * @param json
	 */
	public void set(String key, String json) {
		this.getRedisService().hset(getHashKeyOfSession(), key, json);
	}

	/**
	 * 保存sessions属性
	 * @param key
	 * @param obj
	 */
	public void set(String key, Object obj){
		String json = JSONObject.toJSONString(obj).toString();
		set(key, json);
	}

	/**
	 * 删除session中属性
	 * @param fields
	 */
	public void remove(Object ...fields){
		this.getRedisService().hdel(getHashKeyOfSession(), fields);
	}

	/**
	 * session中保存当前登录用户
	 * @param userContextEntity
	 */
	public void setCurrentUser(UserContextEntity userContextEntity){
		this.set("key", userContextEntity);
	}


	/**
	 * 清除session中保存当前登录用户
	 *
	 */
	public void clearCurrentUser(){
		this.getRedisService().hdel(getHashKeyOfSession(), "key");
	}

	/**
	 * 当前session中的登录用户
	 *
	 * @param clazz
	 * @return
	 */
	UserContextEntity getCurrentUserContext(Class<? extends IUser> clazz){
		String json = (String) this.getRedisService().hget(getHashKeyOfSession(), "key");
		UserContextEntity userContextEntity = null;
		if(StringUtil.isNotEmpty(json)){
			try{
				JSONObject jsonObject = JSONObject.parseObject(json);
				userContextEntity = JSONObject.parseObject(json, UserContextEntity.class);
				// user信息单独解析
				if(clazz!=null
						&& userContextEntity!=null
						&& jsonObject.getJSONObject(UserContextEntity.JSON_FIELD_USER)!=null) {

					IUser user = JSONObject.parseObject(jsonObject.get(UserContextEntity.JSON_FIELD_USER).toString(),clazz);
					userContextEntity.setUser(user);
					userContextEntity.setId(user.getId());

				}

			}catch (Exception e) {
				LoggerUtil.error("getCurrentUser出现异常",e);
			}
		}
		
		return userContextEntity;
	}

	/**
	 * 获取当前token
	 *
	 * @return
	 */
	public String getToken() {
		return token;
	}

	/**
	 * sentToken
	 *
	 * @param token
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * 获取缓存中用户信息，存储的key
	 * @return
	 */
	public String getHashKeyOfSession(){
		return "key" + this.token;
	}

	/**
	 * 返回redisSrvice
	 * @return
	 */
	private RedisService getRedisService(){
		return SpringBeanUtil.getBean(RedisService.class);
	}

	public SessionInfo getSessionInfo(){
		return this.sessionInfo;
	}
}