package com.shepherd.springcloudproduct.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shepherd.springcloudproduct.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/16 15:19
 */
@Repository
@Mapper
public interface CategoryDAO extends BaseMapper<Category> {
}
