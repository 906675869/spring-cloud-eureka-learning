package com.qianxp.eurekaclient.controll;

import com.qianxp.eurekaclient.entity.Consumer;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    private Log log = LogFactory.getLog(this.getClass());
    // 消费者
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Consumer helloConsumer(){
        log.info("消费hello---client3");
        return new Consumer(1,"consumerName","consumerAction","consumerAddress");
    }
}
