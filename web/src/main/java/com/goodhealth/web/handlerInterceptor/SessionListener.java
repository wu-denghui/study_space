package com.goodhealth.web.handlerInterceptor;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
ServletContext对象的监听器  implements  ServletContextListener
HttpSession对象的监听器                HttpSessionListener
ServletRequest对象的监听器             ServletRequestListener
*/


@WebListener
public class SessionListener implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
