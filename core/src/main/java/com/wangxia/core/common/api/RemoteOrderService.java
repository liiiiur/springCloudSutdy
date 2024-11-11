package com.wangxia.core.common.api;

import com.wangxia.core.common.constant.AjaxResult;
import com.wangxia.core.common.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.*;

@FeignClient("orderService")
public interface RemoteOrderService {

    @GetMapping("/order/get")
    AjaxResult getOrderById(@RequestParam("id") String id);

    @PostMapping("/order/save")
    AjaxResult saveOrder(@RequestBody OrderDto orderDto);

    @DeleteMapping("/order/{id}")
    AjaxResult deleteOrderById(@PathVariable("id") String id);
}
