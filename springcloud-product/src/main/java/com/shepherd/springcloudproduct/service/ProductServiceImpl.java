package com.shepherd.springcloudproduct.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shepherd.springcloudproduct.api.service.ProductService;
import com.shepherd.springcloudproduct.dao.ProductDAO;
import com.shepherd.springcloudproduct.entity.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/15 20:06
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDAO productDAO;

    @Override
    public List<Product> getProductList() {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        List<Product> products = productDAO.selectList(queryWrapper);
        return products;
    }
}
