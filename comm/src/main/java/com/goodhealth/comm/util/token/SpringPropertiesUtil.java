package com.goodhealth.comm.util.token;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description  读取配置文件信息，只能读取自定义的配置信息，spring 容器默认的配置信息会读不到
 * @Author WDH
 * @Date 2019/9/21 8:22
 **/

@Component
public class SpringPropertiesUtil {

    private static Properties props ;

    public SpringPropertiesUtil(){

        try {
            Resource resource = new ClassPathResource("/application.properties");
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 当配置文件放在jar包外 即与src目录同级可使用以下方式读取路径
     * String filePath = System.getProperty("user.dir") + "/config/data.properties";
     * @param sourcePath
     */
    public SpringPropertiesUtil(String sourcePath){

        try {
            Resource resource = new ClassPathResource(sourcePath);
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取属性
     * @param key
     * @return
     */
    public static String getProperty(String key){
        return props == null ? null :  props.getProperty(key);
    }

    /**
     * 获取属性
     * @param key 属性key
     * @param defaultValue 属性value
     * @return
     */
    public static String getProperty(String key,String defaultValue){

        return props == null ? null : props.getProperty(key, defaultValue);

    }

    /**
     * 获取properyies属性
     * @return
     */
    public static Properties getProperties(){
        return props;
    }
}

