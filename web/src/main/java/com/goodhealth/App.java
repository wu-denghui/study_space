package com.goodhealth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.servlet.MultipartConfigElement;

/**
 * @author 24663
 * @date 2018年12月31日
 * @Description
 */
@EnableCaching  //开启缓存
@SpringBootApplication(scanBasePackages = "com.goodhealth")
@ServletComponentScan   //扫描Servlet、Filter、Listener组件
// 整合Mybatis时需要在启动类中使用注解@MapperScan让spring容器去扫描mapper(Dao)文件所在位置
//@MapperScan("com.goodhealth.mybatis.mapper")
@EnableScheduling()
public class App implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/**
	 * 配置文件上传的大小
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//文件最大10M,支持KB,MB为单位
		factory.setMaxFileSize("10MB");
		/// 设置总上传数据总大小10M
		factory.setMaxRequestSize("10MB");
		return factory.createMultipartConfig();
	}

	@Override
	public void run(String... args) throws Exception {
		Logger logger = LoggerFactory.getLogger(App.class);
		logger.error("日志测试开始");
		for(int i=0;i<10;i++){
			logger.error("{} log error test{}",i,i);
		}
		logger.error("日志测试结束");
	}
}
//public class App extends SpringBootServletInitializer {
//	/*
//    当需要将项目打包成war发布的话，需要启动类继承SpringBootServletInitializer类，并且重写configure方法
//        @Override
//        protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//            return builder.sources(App.class);
//        }
//    */
//	public static void main(String[] args) {
//		SpringApplication.run(App.class, args);
//	}
//}