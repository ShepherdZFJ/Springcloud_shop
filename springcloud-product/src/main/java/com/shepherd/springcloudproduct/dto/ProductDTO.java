package com.shepherd.springcloudproduct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shepherd.springcloudproduct.entity.Product;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/16 14:40
 */
@Data
public class ProductDTO {
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Long categoryType;

    @JsonProperty("foods")
    List<Product> productList;

    List<Long> productIds;

    List<CartDTO> cartList;
}
