package com.qianxp.client2.controll;

import com.qianxp.client2.entity.Consumer;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
public class ConsumerController {
    private Log log = LogFactory.getLog(this.getClass());
    // 消费者
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Consumer helloConsumer(){

        log.info("消费hello---client2");
        return new Consumer(1,"consumerName","consumerAction","consumerAddress");
    }
}
