package com.shepherd.springcloudproduct.api.controller;

import com.shepherd.springcloudproduct.api.service.CategoryService;
import com.shepherd.springcloudproduct.api.vo.CategoryVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/16 15:31
 */
@RestController
@Api("类目")
@RequestMapping("${spring.web.base-path}/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping
    public CategoryVO getCategoryAndProduct(){
        return categoryService.getCategoryAndProduct();
    }
}
