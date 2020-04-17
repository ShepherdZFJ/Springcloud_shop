package com.shepherd.springcloudorder.service;

import com.shepherd.springcloudorder.api.service.OrderService;
import com.shepherd.springcloudorder.entity.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/17 16:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {

    @Resource
    private OrderService orderService;

    @Test
    public void getOrderList() {
        List<OrderMaster> orderList = orderService.getOrderList();
        System.out.println(orderList);

    }
}