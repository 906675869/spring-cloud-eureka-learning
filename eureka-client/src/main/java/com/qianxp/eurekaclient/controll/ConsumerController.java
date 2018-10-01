package com.qianxp.eurekaclient.controll;

import com.qianxp.eurekaclient.entity.Consumer;
import com.qianxp.eurekaclient.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    ConsumerService consumerService;// 客户端负载均衡RESTEMPLATE
    // 消费者
    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        // 返回字符串
        return consumerService.helloConsumer();
    }
}
