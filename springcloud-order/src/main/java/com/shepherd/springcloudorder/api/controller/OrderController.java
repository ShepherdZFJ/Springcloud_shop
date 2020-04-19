package com.shepherd.springcloudorder.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.shepherd.springcloudorder.api.service.CommonService;
import com.shepherd.springcloudorder.api.service.OrderService;
import com.shepherd.springcloudorder.api.vo.OrderVO;
import com.shepherd.springcloudorder.util.OrderUtils;
import com.shepherd.springcloudorder.util.JsonUtils;
import com.shepherd.springcloudorder.dto.CartDTO;
import com.shepherd.springcloudorder.dto.OrderDTO;
import com.shepherd.springcloudorder.entity.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    @Resource
    private CommonService commonService;

    @ApiOperation("添加订单")
    @PostMapping
    public JSONObject addOrder(@RequestBody OrderVO orderVO){
        OrderDTO orderDTO = OrderUtils.copy(orderVO, OrderDTO.class);
        //List<CartDTO> cartDTOS = JsonUtils.josnToList(orderVO.getItems(), CartDTO.class);
        orderDTO.setCartDTOList(orderVO.getItems());
        OrderDTO order = orderService.addOrder(orderDTO);
        JSONObject rst = new JSONObject();
        rst.put("orderId", order.getId());
        return rst;
    }

    @GetMapping()
    public List<Product> getlist(@RequestBody List<Long> productIds){
        List<Product> products = commonService.getproductList(productIds);
        return products;

    }
}
