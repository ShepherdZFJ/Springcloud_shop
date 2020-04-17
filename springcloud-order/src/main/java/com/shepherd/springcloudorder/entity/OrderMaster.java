package com.shepherd.springcloudorder.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/4/17 15:35
 */
@Data
public class OrderMaster implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String orderNo;
    private String buyerName;
    private String buyerAddress;
    private String buyerPhone;
    private String openId;
    private BigDecimal amount;
    private Integer orderStatus;
    private Integer payStatus;
    private Integer isDelete;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
