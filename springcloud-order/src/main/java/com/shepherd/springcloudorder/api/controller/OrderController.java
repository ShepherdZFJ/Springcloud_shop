package com.shepherd.springcloudorder.api.controller;

import com.shepherd.springcloudorder.api.service.OrderService;
import com.shepherd.springcloudorder.api.vo.OrderVO;
import com.shepherd.springcloudorder.common.BeanUtil;
import com.shepherd.springcloudorder.common.JsonUtils;
import com.shepherd.springcloudorder.dto.OrderDTO;
import com.shepherd.springcloudorder.entity.OrderDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/17 15:53
 */
@RestController
@Api("订单")
@RequestMapping("${spring.web.base-path}/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @ApiOperation("添加订单")
    @PostMapping
    public void addOrder(@RequestBody OrderVO orderVO){
        OrderDTO orderDTO = BeanUtil.copy(orderVO, OrderDTO.class);
        List<OrderDetail> orderDetails = JsonUtils.josnToList(orderVO.getItems(), OrderDetail.class);
        orderDTO.setOrderDetailList(orderDetails);
        orderService.addOrder(orderDTO);
    }
}
