package com.shepherd.springcloudorder.api.service;

import com.shepherd.springcloudorder.dto.OrderDTO;
import com.shepherd.springcloudorder.entity.OrderMaster;

import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/17 15:59
 */
public interface OrderService {

    List<OrderMaster> getOrderList();

    OrderDTO addOrder(OrderDTO orderDTO);
}
