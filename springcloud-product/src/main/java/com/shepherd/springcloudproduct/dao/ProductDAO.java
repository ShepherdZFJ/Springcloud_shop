package com.shepherd.springcloudproduct.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shepherd.springcloudproduct.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/15 19:48
 */
@Repository
@Mapper
public interface ProductDAO extends BaseMapper<Product> {
}
