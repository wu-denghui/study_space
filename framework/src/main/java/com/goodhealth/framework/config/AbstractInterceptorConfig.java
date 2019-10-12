//package com.goodhealth.framework.config;
//
//import com.goodhealth.framework.interceptor.EcoSessionInterceptor;
//import com.goodhealth.framework.interceptor.LoginInterceptor;
//import com.goodhealth.framework.interceptor.RefererInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * 配置多个拦截器又存在多种开启情况的拦截器写法----建立拦截器配置抽象类
// * 例如：配置了拦截器A B C
// * 情况1 开启AB
// * 情况2 开启BC
// *  ....
// * 控制是否开启情况只需实现此抽象类并且合理实现isOpenxxxx方法
// */
//public abstract class AbstractInterceptorConfig extends WebMvcConfigurerAdapter {
//
//	/**
//	 * 登录拦截
//	 */
//	@Autowired
//	private LoginInterceptor loginInterceptor;
//
//	@Autowired
//	private EcoSessionInterceptor ecoSessionInterceptor;
//
//	@Autowired
//	private RefererInterceptor refererInterceptor;
//
//	/**
//	 * 是否开启EcoSession拦截器
//	 * @return
//	 */
//	public abstract boolean isOpenEcoSessionInterceptor();
//
//	/**
//	 * 是否开启login拦截器
//	 * @return
//	 */
//	public abstract boolean isOpenLoginInterceptor();
//
//	/**
//	 * 排除EcoSession拦截的地址
//	 *
//	 * @return
//	 */
//	public abstract String[] ecoSessionExcludePathPatterns();
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//
//		// before
//		this.addInterceptorsPre(registry);
//
//		// 开启创建EcoSession
//		if(isOpenEcoSessionInterceptor()){
//
//			InterceptorRegistration registration = registry.addInterceptor(ecoSessionInterceptor)
//					.addPathPatterns("/eco/**");
//			if(ecoSessionExcludePathPatterns()!=null){
//				registration.excludePathPatterns(ecoSessionExcludePathPatterns());
//			}
//		}
//
//		// 登录状态拦截
//		if(isOpenLoginInterceptor()){
//
//          //	开启了登录拦截，则必须要做referer拦截
//			registry.addInterceptor(refererInterceptor).addPathPatterns(GlobalConstants.INTERCEPTOR_PATH_LOGIN);
//
//          //	登录拦截
//			registry.addInterceptor(loginInterceptor).addPathPatterns(GlobalConstants.INTERCEPTOR_PATH_LOGIN);
//		}
//
//		// after
//		this.addInterceptorsAfter(registry);
//
//		super.addInterceptors(registry);
//	}
//
//	/**
//	 * 添加拦截，在默认拦截器之前
//	 * @param registry
//	 */
//	public abstract void addInterceptorsPre(InterceptorRegistry registry);
//
//	/**
//	 * 添加拦截，在默认拦截器之后
//	 * @param registry
//	 */
//	public abstract void addInterceptorsAfter(InterceptorRegistry registry);
//}
