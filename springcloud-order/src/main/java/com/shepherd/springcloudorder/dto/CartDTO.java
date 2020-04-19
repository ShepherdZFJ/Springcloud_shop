package com.shepherd.springcloudorder.dto;

import lombok.Data;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2020/4/19 11:09
 */
@Data
public class CartDTO {
    private Long productId;
    private Integer productQuantity;
}
