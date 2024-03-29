package com.wangxia.order.controller;

import com.wangxia.core.core.common.constant.AjaxResult;
import com.wangxia.core.core.common.dto.OrderDto;
import com.wangxia.order.domain.Order;
import com.wangxia.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@RestController("/order")
@Tag(name = "订单微服务")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(description = "通过id获取订单",summary = "获取订单")
    @GetMapping("/{id}")
    public AjaxResult getOrderById(@PathVariable("id") Integer id) {
        return AjaxResult.success(orderService.getById(id));
    }

    @PostMapping("/save")
    public AjaxResult saveOrder(@RequestBody OrderDto orderDto) {

        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);

        boolean save = orderService.save(order);
        if(save){
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    @DeleteMapping("/{id}")
    public AjaxResult deleteOrderById(@PathVariable("id") Integer id) {
        boolean b = orderService.removeById(id);
        if(b){
            return AjaxResult.success();
        }else {
            return AjaxResult.error();
        }
    }
}
