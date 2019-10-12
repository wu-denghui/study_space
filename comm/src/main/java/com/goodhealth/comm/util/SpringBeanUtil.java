package com.goodhealth.comm.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description  获得spring容器里的bean  用于不适合Autowire注入组件的时候
 *    例如在Component组件（非controller非Service）中调用某一server
 * @Author WDH
 * @Date 2019/9/7 16:29
 **/
@Component
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    @SuppressWarnings("static-access")
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 获取上下文对象
     *
     * @return context
     */
    public static ApplicationContext getContext() {
        return context;
    }

    /**
     * 判断上下文对象是否为空
     *
     * @return
     */
    public static boolean checkApplicationContext() {
        return getContext() != null;
    }

    /**
     * 根据name获取bean
     *
     * @param name
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        if (checkApplicationContext()) {
            return (T) getContext().getBean(name);
        } else {
            return null;
        }
    }

    /**
     * 根据class 获取bean
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        if (checkApplicationContext()) {
            return getContext().getBean(clazz);
        } else {
            return null;
        }
    }

    /**
     * 根据name,以及Clazz返回指定的Bean
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        if (checkApplicationContext()) {
            return getContext().getBean(name, clazz);
        } else {
            return null;
        }
    }
}
