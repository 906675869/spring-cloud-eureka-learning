package com.qianxp.eurekaclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qianxp.eurekaclient.entity.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {
    @Autowired
    private RestTemplate restTemplate;// 客户端负载均衡RESTEMPLATE

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloConsumer(){
        // 返回字符串
        String url = "http://eureka-client-service/hello";
        //return restTemplate.getForEntity("http://eureka-client-service/hello",String.class).getBody();
        // 返回对象
       return restTemplate.getForEntity("http://eureka-client-service/hello", Consumer.class).getBody().toString();
        // GET FOR OBJECT
        //return restTemplate.getForObject(url,String.class);
//        return restTemplate.postForObject(url,String.class,String.class);
    }
    public String helloFallback(){
        return "error";
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
