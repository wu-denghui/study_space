package com.goodhealth.web.handlerInterceptor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/xx/xx", filterName = "easyFilter")
public class GHFliter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 用于完成Filter的初始化
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        if (1==1){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            response.sendRedirect("/index.html");
        }
    }

    @Override
    public void destroy() {
        // 用于Filter销毁前，完成某些资源的回收
    }
}
