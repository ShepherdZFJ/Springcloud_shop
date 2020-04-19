package com.shepherd.springcloudproduct.api.controller;

import com.shepherd.springcloudproduct.api.service.ProductService;
import com.shepherd.springcloudproduct.api.vo.ProductVO;
import com.shepherd.springcloudproduct.dto.CartDTO;
import com.shepherd.springcloudproduct.entity.Product;
import io.swagger.annotations.Api;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/15 19:37
 */
@RestController
@Api("商品")
@RequestMapping("${spring.web.base-path}/product")
public class ProductController {
    @Resource
    private ProductService productService;

    /**
     * 此接口用于获取类目和商品信息给前端
     * @return
     */
    @GetMapping()
    public ProductVO getProduct(){
        return productService.getProduct();
    }

    @PostMapping("/productList")
    public List<Product> getproductList(@RequestBody List<Long> productIds){
        return productService.getProductList(productIds);
    }

    @PutMapping("/stock")
    public void decreaseStock(@RequestBody List<CartDTO> cartList){
        productService.decreaseStock(cartList);
    }
}
