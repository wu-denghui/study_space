package com.goodhealth.framework.session;

import com.goodhealth.framework.entity.user.IUser;
import com.goodhealth.framework.entity.user.UserClientInfoEntity;
import com.goodhealth.framework.entity.user.UserContextEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.goodhealth.comm.util.restful.HttpUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @描述：无状态session
 */
public class SessionManager {
	
	public static final String REQUEST_SESSION = "session_rq";

	/**
	 * 获取session
	 * @param request
	 * @return
	 */
	public static final DefaultSession getSession(HttpServletRequest request){
		try{
			return (DefaultSession)request.getAttribute(REQUEST_SESSION);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 生成 session
	 * @param request
	 * @return
	 */
	protected final boolean initEcoSession(HttpServletRequest request){
		request.setAttribute(REQUEST_SESSION,new DefaultSession());
		return true;
	}

	/**
	 * 生成单元测试session
	 * @param request
	 * @return
	 */
	public static final boolean initJunitEcoSession(HttpServletRequest request){
		request.setAttribute(REQUEST_SESSION,new DefaultSession());
		return true;
	}


	/**
	 * 返回当前登录用户上下文
	 *
	 * @param request
	 * @param userClazz
	 * @return
	 */
	public static final UserContextEntity getCurrentUserContext(HttpServletRequest request, Class<? extends IUser> userClazz){
		DefaultSession ecoSession = SessionManager.getSession(request);
		if(ecoSession!=null){
			return ecoSession.getCurrentUserContext(userClazz);
		}
		return null;
	}


	/**
	 * 返回当前登录用户
	 * @param userClazz
	 * @return
	 */
	public static final IUser getCurrentUser(Class<? extends IUser> userClazz){
		return getCurrentUser(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(), userClazz);
	}


	/**
	 * 删除当前sessin中的用户信息
	 */
	public static final void clearCurrentUserOfSession(){
		DefaultSession ecoSession = SessionManager.getSession(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
		if(ecoSession!=null) {
			ecoSession.clearCurrentUser();
		}
	}

	/**
	 * 返回当前登录用户
	 *
	 * @param userClazz
	 * @return
	 */
	private static final IUser getCurrentUser(HttpServletRequest request, Class<? extends IUser> userClazz){
		UserContextEntity userContextEntity = getCurrentUserContext(request, userClazz);
		return userContextEntity==null? null:userContextEntity.getUser();
	}

	/**
	 * 保存session信息，并返回客户端用户信息
	 *
	 * @param user 登录信息
	 * @param timeout session超时时间(小于1的话，为系统默认)
	 * @param request
	 */
	public static final void saveCurrentUserContextSession(IUser user, int timeout, HttpServletRequest request){

		// 自定义session
		DefaultSession session = getSession(request);

		if(session==null){
			return;
		}

		// 客户端环境信息
		UserClientInfoEntity clientInfoEntity = new UserClientInfoEntity();
		clientInfoEntity.setClientIp(HttpUtil.getUserClientIp(request));
		clientInfoEntity.setUserAgent(request.getHeader("User-Agent"));

		// 客户信息
		UserContextEntity userContextEntity = new UserContextEntity();
		userContextEntity.setUser(user);
		userContextEntity.setId(user.getId());
		userContextEntity.setUserClientInfoEntity(clientInfoEntity);

		//获取菜单信息
		String userId = user.getId();

		//用户信息存入session
		session.setCurrentUser(userContextEntity);
		if (timeout > 0) {
			session.resetTimeout(timeout);
		}

	}

	
}