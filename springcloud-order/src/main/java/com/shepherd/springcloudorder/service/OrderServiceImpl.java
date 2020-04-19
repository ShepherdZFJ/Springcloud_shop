package com.shepherd.springcloudorder.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shepherd.springcloudorder.api.service.CommonService;
import com.shepherd.springcloudorder.api.service.OrderService;
import com.shepherd.springcloudorder.common.Constant;
import com.shepherd.springcloudorder.dao.OrderDetailDAO;
import com.shepherd.springcloudorder.util.KeyUtils;
import com.shepherd.springcloudorder.util.OrderUtils;
import com.shepherd.springcloudorder.dao.OrderDAO;
import com.shepherd.springcloudorder.dto.CartDTO;
import com.shepherd.springcloudorder.dto.OrderDTO;
import com.shepherd.springcloudorder.entity.OrderDetail;
import com.shepherd.springcloudorder.entity.OrderMaster;
import com.shepherd.springcloudorder.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    @Resource
    private OrderDetailDAO orderDetailDAO;
    @Resource
    private CommonService commonService;

    @Override
    public List<OrderMaster> getOrderList() {
        QueryWrapper<OrderMaster> orderQueryWrapper = new QueryWrapper<>();
        List<OrderMaster> orders = orderDAO.selectList(orderQueryWrapper);
        return orders;
    }

    @Override
    @Transactional
    public OrderDTO addOrder(OrderDTO orderDTO) {

        //1.根据购物车获取商品详情
        List<Long> productIdList = orderDTO.getCartDTOList().stream().map(CartDTO::getProductId).collect(Collectors.toList());
        List<Product> products = commonService.getproductList(productIdList);

        //2.计算订单总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for(CartDTO cartDTO : orderDTO.getCartDTOList()){
            for(Product product : products){
                if(cartDTO.getProductId() == product.getId()){
                    orderAmount = product.getPrice().multiply(new BigDecimal((cartDTO.getProductQuantity()))).add(orderAmount);
                }
            }
        }

        //3.添加订单
        orderDTO.setAmount(orderAmount);
        orderDTO.setIsDelete(Constant.NOT_DEL);
        orderDTO.setOrderNo(KeyUtils.genUniqueKey());
        OrderMaster orderMaster = OrderUtils.copy(orderDTO, OrderMaster.class);
        int i = orderDAO.insert(orderMaster);

        //4.添加订单详情数据
        for(CartDTO cartDTO : orderDTO.getCartDTOList()){
            OrderDetail orderDetail = new OrderDetail();
            for(Product product : products){
                if(cartDTO.getProductId() == product.getId()){
                    orderDetail.setProductId(product.getId());
                    orderDetail.setProductName(product.getName());
                    orderDetail.setProductPrice(product.getPrice());
                    orderDetail.setProductIcon(product.getIcon());
                    orderDetail.setProductQuantity(cartDTO.getProductQuantity());
                    orderDetail.setIsDelete(Constant.NOT_DEL);
                    orderDetail.setOrderId(orderMaster.getId());
                }
            }
            int result = orderDetailDAO.insert(orderDetail);
        }

        //5.扣除商品库存
        commonService.decreaseStock(orderDTO.getCartDTOList());

        return OrderUtils.copy(orderMaster,orderDTO);

    }
}
