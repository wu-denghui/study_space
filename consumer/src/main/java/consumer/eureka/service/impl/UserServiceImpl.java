package consumer.eureka.service.impl;

import consumer.eureka.pojo.User;
import consumer.eureka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public List<User> getUser() {
        //选择调用的服务的名称
        //ServiceInstance 封装了服务的基本信息，如 IP，端口
        ServiceInstance instance = this.loadBalancerClient.choose("provider");
        //拼接访问服务的URL
        StringBuffer url = new StringBuffer();
        int port = instance.getPort();
        String host = instance.getHost();
        url.append("http://").append(host).append(":").append(port).append("/user/getUser");
        //springMVC RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<List<User>> type = new ParameterizedTypeReference<List<User>>() {};
        //ResponseEntity:封装了返回值信息
        ResponseEntity<List<User>> response = restTemplate.exchange(url.toString(), HttpMethod.GET,null,type);
        return response.getBody();
    }
}
