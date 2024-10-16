package com.wangxia.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangxia.order.domain.Order;
import com.wangxia.order.mapper.OrderMapper;
import com.wangxia.order.service.OrderService;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author liur
* @description 针对表【o_order】的数据库操作Service实现
* @createDate 2024-03-22 09:31:31
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void enableConfirmCallback(){
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if(!ack){
                    System.out.println("ack发送失败");
                }else {
                    System.out.println("ack发送成功");
                }
            }
        });

        rabbitTemplate.setReturnsCallback(returned -> {
            System.out.println("发送到交换机没有到队列");
        });
    }

    @Override
    public boolean saveOrder(Order order) {
        boolean save = this.saveOrUpdate(order);
        if(save) rabbitTemplate.convertAndSend("order_exchange","order_routing_key",order);
        return save;
    }
}




