package com.shepherd.springcloudproduct.dao;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.shepherd.springcloudproduct.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/5/19 16:21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ProductDAOTest {
    @Resource
    private ProductDAO productDAO;

    @Test
    public void testUpdate(){
        Product product = new Product();
       // product.setId(1L);
        product.setStock(30);
        product.setName("sdfdf");
        //更新product对象非空的字段，UPDATE product SET name=?, stock=? WHERE id=?
        //int i = productDAO.updateById(product);
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", 1L);
        int i = productDAO.update(product, updateWrapper);
        System.out.println(i);
    }
}