package com.shepherd.springcloudproduct.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/16 15:08
 */
@Data
public class Category {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer isDelete;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
