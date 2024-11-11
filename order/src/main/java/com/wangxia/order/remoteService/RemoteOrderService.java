package com.wangxia.order.remoteService;


import com.wangxia.core.common.constant.AjaxResult;
import com.wangxia.core.common.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "order",url = "/order")
public interface RemoteOrderService {

    @GetMapping("/{id}")
    AjaxResult getOrderById(@PathVariable("id") Integer id);

    @PostMapping("/save")
    AjaxResult saveOrder(@RequestBody OrderDto orderDto);

    @DeleteMapping("/{id}")
    AjaxResult deleteOrderById(@PathVariable("id") Integer id);
}