package com.goodhealth.framework.interceptor;

import com.goodhealth.comm.util.StringUtil;
import com.goodhealth.comm.util.token.SpringPropertiesUtil;
import jdk.nashorn.internal.runtime.GlobalConstants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description   检验请求头中的referer 防御CSRF（跨站请求伪造）
 * @Author WDH
 * @Date 2019/9/21 8:11
 **/
public class RefererInterceptor implements HandlerInterceptor {
    /**
     *
     * 请求header中referer校验，
     * 验证referer为 自己网站的referer
     *
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        // 请求header中的referer
        String referer = request.getHeader("referer");

        // 如果请求中没有referer，则不做检查
        if(StringUtil.isBlank(referer)){
            return true;
        }

        // 如果未配置需要忽略的ignore_referer
        String ignoreReferer = SpringPropertiesUtil.getProperty("framework.ignore.referer");

        // 如果ignore_referer未做配置，则不做校验，避免误校验
        if(StringUtil.isBlank(ignoreReferer)){
            return true;
        }

        // 如果请求header中的referer，被配置为可忽略，则不拦截请求
        if(!"*".equals(ignoreReferer)){
            String[] ignoreReArray = ignoreReferer.split(";");
            for(String ignore : ignoreReArray){
                if(referer.contains(ignore)){
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
