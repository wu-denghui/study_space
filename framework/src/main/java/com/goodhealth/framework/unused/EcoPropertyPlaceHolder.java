///*
// * Copyright by Deppon and the original author or authors.
// *
// * This document only allow internal use ,Any of your behaviors using the file
// * not internal will pay legal responsibility.
// *
// * You may learn more information about Deppon from
// *
// *
// *      http://www.deppon.com
// *
// */
//package config;
//
//import com.deppon.dpboot.module.ucmc.bootconfig.UcmcPropertyPlaceHolder;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.cloud.context.refresh.ContextRefresher;
//
//import javax.annotation.Resource;
//import java.io.IOException;
//import java.util.Properties;
//
///**
// * ucmc配置加载
// * @author yadongcui
// * @date 2019-04-26 10:48
// */
//public class EcoPropertyPlaceHolder extends UcmcPropertyPlaceHolder {
//
//    @Resource
//    private ContextRefresher contextRefresher;
//
//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        super.postProcessBeanFactory(beanFactory);
//    }
//
//    @Override
//    protected Properties mergeProperties() throws IOException {
//        Properties properties = super.mergeProperties();
//
//        // 将配置放到System
//        for(String key : properties.stringPropertyNames()){
//            System.setProperty(key, properties.getProperty(key));
//        }
//        return properties;
//    }
//
//    @Override
//    protected String resolvePlaceholder(String key, Properties properties) {
//        return super.resolvePlaceholder(key, properties);
//    }
//
//}
