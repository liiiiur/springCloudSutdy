package com.wangxia.core.core.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderDto {

    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 目标产品Id
     */
    private String productId;

    /**
     * 用户id
     */
    private String userId;
}
