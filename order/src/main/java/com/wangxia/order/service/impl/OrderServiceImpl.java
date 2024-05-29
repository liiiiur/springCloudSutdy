package com.wangxia.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxia.order.domain.Order;
import com.wangxia.order.mapper.OrderMapper;
import com.wangxia.order.service.OrderService;
import org.springframework.stereotype.Service;

/**
* @author liur
* @description 针对表【o_order】的数据库操作Service实现
* @createDate 2024-03-22 09:31:31
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService {

}




