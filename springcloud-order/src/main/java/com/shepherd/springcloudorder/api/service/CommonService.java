package com.shepherd.springcloudorder.api.service;

import com.shepherd.springcloudorder.dto.CartDTO;
import com.shepherd.springcloudorder.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2020/4/18 20:50
 */
@FeignClient(name="springcloud-product",url = "http://127.0.0.1:8801/sell/api/product")
public interface CommonService {

    @PostMapping("/productList")
    public List<Product> getproductList(@RequestBody List<Long> productIds);

    @PutMapping("/stock")
    public void decreaseStock(@RequestBody List<CartDTO> cartList);
}
