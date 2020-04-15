package com.shepherd.springcloudproduct.service;

import com.shepherd.springcloudproduct.api.service.ProductService;
import com.shepherd.springcloudproduct.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/15 20:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

    @Resource
    private ProductService productService;

    @Test
    public void getProductList() {
        List<Product> productList = productService.getProductList();
        System.out.println(productList);

    }
}