package com.goodhealth.framework.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        /*System.out.println(request.getRequestURI());
        System.out.println(request.getContextPath()+"/goodhealth/admin/login");
        //登录、注册不做拦截
        if(request.getRequestURI().contains("/user/")) {
            return true;
        }
        try {
            HttpSession session = request.getSession(true);
            if (Objects.nonNull(session.getAttribute("member"))){
                return true;
            }
            if (request.getRequestURI().contains("admin")){
                response.sendRedirect(request.getContextPath()+"/goodhealth/admin/login");
                return false;
            }else{
                response.sendRedirect(request.getContextPath()+"/goodhealth/login");
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect(request.getContextPath()+"/goodhealth/login");
        }
        return false;*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // Controller之后调用，视图渲染之前，如果控制器Controller出现了异常，则不会执行此方法
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        // 整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行，
        // 不管Controller有没有异常，这个afterCompletion都会被调用，用于资源清理
    }

}
