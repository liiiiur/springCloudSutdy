package com.wangxia.order.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.wangxia.core.core.common.entity.BaseEntity;
import lombok.Data;

/**
 * 
 * @TableName o_order
 */
@TableName(value ="o_order")
@Data
public class Order extends BaseEntity implements Serializable {
    /**
     * 
     */
    @TableId
    private String orderId;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 目标产品id
     */
    private String productId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}