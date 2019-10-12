//package config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.http.converter.FormHttpMessageConverter;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @ClassName RestTemplateConfig
// * @Description TODO
// * @Author WDH
// * @Date 2019/8/14 17:01
// * @Version 1.0
// **/
//@Configuration
//public class RestTemplateConfig {
//
//    @Bean(name = "restClient")
//    public RestTemplate getRestClient(){
//        RestTemplate restClient = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
//        // set message converters
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//        // set string converter
//        messageConverters.add(new StringHttpMessageConverter());
//        // set json converter
//        messageConverters.add(new MappingJackson2HttpMessageConverter());
//        // set form converter
//        messageConverters.add(new FormHttpMessageConverter());
//        restClient.setMessageConverters(messageConverters);
//        return restClient;
//    }
//}
