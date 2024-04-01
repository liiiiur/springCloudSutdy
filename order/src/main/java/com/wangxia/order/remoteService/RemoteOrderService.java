package com.wangxia.order.remoteService;


import com.wangxia.core.core.common.constant.AjaxResult;
import com.wangxia.core.core.common.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "orderService",url = "/order")
public interface RemoteOrderService {

    @GetMapping("/{id}")
    AjaxResult getOrderById(@PathVariable("id") Integer id);

    @PostMapping("/save")
    public AjaxResult saveOrder(@RequestBody OrderDto orderDto);

    @DeleteMapping("/{id}")
    public AjaxResult deleteOrderById(@PathVariable("id") Integer id);
}