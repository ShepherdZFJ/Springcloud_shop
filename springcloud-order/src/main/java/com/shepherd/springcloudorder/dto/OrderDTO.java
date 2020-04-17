package com.shepherd.springcloudorder.dto;

import com.shepherd.springcloudorder.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/17 16:36
 */
@Data
public class OrderDTO {

    /** 订单id. */
    private String id;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String openId;

    /** 订单总金额. */
    private BigDecimal amount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
