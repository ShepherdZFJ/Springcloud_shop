package com.shepherd.springcloudorder.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shepherd.springcloudorder.entity.OrderMaster;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/17 15:49
 */
@Repository
@Mapper
public interface OrderDAO extends BaseMapper<OrderMaster> {
}
