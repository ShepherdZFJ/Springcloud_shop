package com.shepherd.springcloudorder.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shepherd.springcloudorder.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/17 15:50
 */
@Repository
@Mapper
public interface OrderDetailDAO extends BaseMapper<OrderDetail> {
}
