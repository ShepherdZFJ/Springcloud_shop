package com.shepherd.springcloudorder.message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2020/5/7 21:39
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MqReceiverTest {

    @Resource
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("autoQueue", "now:"+new Date());

    }


}