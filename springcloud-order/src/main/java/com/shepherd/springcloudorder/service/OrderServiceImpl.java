package com.shepherd.springcloudorder.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shepherd.springcloudorder.api.service.OrderService;
import com.shepherd.springcloudorder.dao.OrderDAO;
import com.shepherd.springcloudorder.dto.OrderDTO;
import com.shepherd.springcloudorder.entity.OrderDetail;
import com.shepherd.springcloudorder.entity.OrderMaster;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/17 16:01
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDAO orderDAO;

    @Override
    public List<OrderMaster> getOrderList() {
        QueryWrapper<OrderMaster> orderQueryWrapper = new QueryWrapper<>();
        List<OrderMaster> orders = orderDAO.selectList(orderQueryWrapper);
        return orders;
    }

    @Override
    public void addOrder(OrderDTO orderDTO) {

        List<Long> productIdList = orderDTO.getOrderDetailList().stream().map(OrderDetail::getId).collect(Collectors.toList());

    }
}
