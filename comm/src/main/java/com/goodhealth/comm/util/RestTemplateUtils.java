package com.goodhealth.comm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName RestTemplateUtils
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/14 15:28
 * @Version 1.0
 **/
public class RestTemplateUtils {

    @Autowired
    private RestTemplate restClient;

/*    RestTemplate定义了36个与REST资源交互的方法，其中的大多数都对应于HTTP的方法。
    其实，这里面只有11个独立的方法，其中有十个有三种重载形式，而第十一个则重载了六次，这样一共形成了36个方法。
    delete() 在特定的URL上对资源执行HTTP DELETE操作
    exchange()
    在URL上执行特定的HTTP方法，返回包含对象的ResponseEntity，这个对象是从响应体中映射得到的
    execute() 在URL上执行特定的HTTP方法，返回一个从响应体映射得到的对象
    getForEntity() 发送一个HTTP GET请求，返回的ResponseEntity包含了响应体所映射成的对象
    getForObject() 发送一个HTTP GET请求，返回的请求体将映射为一个对象
    postForEntity()
    POST 数据到一个URL，返回包含一个对象的ResponseEntity，这个对象是从响应体中映射得到的
    postForObject() POST 数据到一个URL，返回根据响应体匹配形成的对象
    headForHeaders() 发送HTTP HEAD请求，返回包含特定资源URL的HTTP头
    optionsForAllow() 发送HTTP OPTIONS请求，返回对特定URL的Allow头信息
    postForLocation() POST 数据到一个URL，返回新创建资源的URL
    put() PUT 资源到特定的URL
    实际上,由于Post 操作的非幂等性,它几乎可以代替其他的CRUD操作.*/

    public void restGet(){
        String url = "http_url";
        HashMap<String,String> map = new HashMap<>();
        map.put("参数一","111");
        map.put("参数二","222");
        RestTemplate restTemplate = new RestTemplate();
        // ResponseEntity 继承了HttpEntity.封装了返回的响应信息,包括 响应状态,响应头 和 响应体.
        ResponseEntity<String> entity = restTemplate.getForEntity(url,String.class,"参数一","参数二");
        // getForObject 和 getForEntity 用法几乎相同,指示返回值返回的是 响应体,省去了我们 再去 getBody()
        String res = restTemplate.getForObject(url,String.class,"参数一","参数二");
        //  ResponseEntity<String> entity = restTemplate.getForEntity(url,String.class,map);
        //  调用的restful服务url无参数 ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://localhost/getAll", List.class);
        String body = entity.getBody();
        int httpStatus = entity.getStatusCode().value();
        MediaType mediaType = entity.getHeaders().getContentType();
    }


    public void restPost(Object object){
        String url = "http_url";
        HashMap<String,String> map = new HashMap<>();
        map.put("参数一","111");
        map.put("参数二","222");
        RestTemplate restTemplate = new RestTemplate();
        // ResponseEntity 继承了HttpEntity.封装了返回的响应信息,包括 响应状态,响应头 和 响应体.
        ResponseEntity<String> entity = restTemplate.postForEntity(url,object,String.class,"参数一");
        // postForObject 和 postForEntity 用法几乎相同,指示返回值返回的是 响应体,省去了我们 再去 getBody()
        String res = restTemplate.postForObject(url,object,String.class);
        //  ResponseEntity<String> entity = restTemplate.postForEntity(url,object,String.class,map);
        //  调用的restful服务url无参数 ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://localhost/getAll", List.class);
        String body = entity.getBody();
        int httpStatus = entity.getStatusCode().value();
        MediaType mediaType = entity.getHeaders().getContentType();
    }

    /*
     * @Author WDH
     * @Description  exchange()利用HttpMethod这个参数，可以完成其他RestTemplate方法的工作，如上GET、POST、DELETE、PUT等。
     * exchange()优于其他方法的点事它可以在发送给服务器的请求中加入头信息。
     * @Param
     * @return
    **/
    public void restExchange(){
        String url = "http_url";
        HttpHeaders headers = new HttpHeaders();// set header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));// set content type
        headers.set("skipAuthorization", "true");// set attirubte
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);// set accept
        // 组装在请求中发送的资源
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("username", "张十八");// set parameter
        map.add("password", "123456");// set parameter
        map.add("ip", "192.125.2.1");// set parameter
//        Object o = new Object();
        // 在此加入请求头信息
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//        HttpEntity<Object> entity = new HttpEntity<>(o, headers);
        // String|URL ：请求路径
        // HttpMethod：Http的动作，如Get、delete等
        // requestEntity()：在请求中发送资源，get可以为null
        // responseType（如果要获取状态码和header可使用ResponseEntity<T>）：返回数据的类型
        // Map/Object... ：填充Url的参数
        ResponseEntity<String> responseEntity = restClient.exchange(url, HttpMethod.POST, entity, String.class);
        ParameterizedTypeReference<List<String>> responseType =new ParameterizedTypeReference<List<String>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
        ResponseEntity<List<String>> responseEntityL = restClient.exchange(url, HttpMethod.POST, entity,responseType);
        String res = responseEntity.getBody();
        responseEntity.getStatusCode().value();
        responseEntity.getHeaders();
    }



}
