package com.shepherd.springcloudorder.api.vo;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/17 16:32
 */
@Data
public class OrderVO {

    /**
     * 买家姓名
     */
    @NotNull(message = "姓名必填")
    private String buyerName;


    /**
     * 买家手机号
     */
    @NotNull(message = "手机号必填")
    private String buyerPhone;

    /**
     * 买家地址
     */
    @NotNull(message = "地址必填")
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    @NotNull(message = "openid必填")
    private String openId;

    /**
     * 购物车
     */
    @NotNull(message = "购物车不能为空")
    private String items;

}
