package com.shepherd.springcloudproduct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shepherd.springcloudproduct.entity.Product;
import lombok.Data;

import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/16 19:52
 */
@Data
public class CategoryDTO {

    private Long id;
    private String name;
    @JsonProperty("foods")
    List<Product> productList;

}
