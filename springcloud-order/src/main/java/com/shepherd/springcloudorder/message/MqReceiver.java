package com.shepherd.springcloudorder.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2020/5/7 21:34
 */
@Slf4j
@Component
public class MqReceiver {

//  @RabbitListener(queues = "myQueue") 此方式必须先在rabbitMq里面先添加myQueue队列，否则会报错
    @RabbitListener(queuesToDeclare = @Queue("autoQueue"))
    private void process(String msg){
        //System.out.println("MqReceiver:"+msg);
        log.info("MqReceiver: {}", msg);
    }
}
