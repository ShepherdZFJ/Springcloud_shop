package com.shepherd.springcloudproduct.dto;

import lombok.Data;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2020/4/18 23:49
 */
@Data
public class CartDTO {

    private Long productId;
    private Integer productQuantity;
}
