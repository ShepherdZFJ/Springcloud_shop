package com.shepherd.springcloudorder.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shepherd.springcloudorder.api.service.OrderService;
import com.shepherd.springcloudorder.dao.OrderDAO;
import com.shepherd.springcloudorder.entity.OrderMaster;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
