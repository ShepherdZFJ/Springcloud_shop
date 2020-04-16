package com.shepherd.springcloudproduct.api.service;

import com.shepherd.springcloudproduct.api.vo.ProductVO;
import com.shepherd.springcloudproduct.dto.ProductDTO;
import com.shepherd.springcloudproduct.entity.Product;

import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/15 20:05
 */
public interface ProductService {

    List<Product> getProductList();
    ProductVO getProduct();


}
