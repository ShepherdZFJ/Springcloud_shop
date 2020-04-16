package com.shepherd.springcloudproduct.api.controller;

import com.shepherd.springcloudproduct.api.service.ProductService;
import com.shepherd.springcloudproduct.api.vo.ProductVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/15 19:37
 */
@RestController
@Api("应用配置中心")
@RequestMapping("${spring.web.base-path}/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping()
    public ProductVO getProductList(){
        return productService.getProduct();
    }
}
