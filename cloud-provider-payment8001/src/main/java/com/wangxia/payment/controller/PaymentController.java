package com.wangxia.payment.controller;

import com.wangxia.core.core.common.api.RemoteOrderService;
import com.wangxia.core.core.common.api.RemotePhotoService;
import com.wangxia.core.core.common.constant.AjaxResult;
import com.wangxia.core.core.common.dto.OrderDto;
import com.wangxia.core.core.common.dto.PaymentDto;
import com.wangxia.core.core.common.dto.PhotoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController("/payment")
@Tag(name = "支付端微服务",description = "支付端")
public class PaymentController {

    @Resource
    private  RemoteOrderService remoteOrderService;

    @Resource
    private RemotePhotoService remotePhotoService;

    @Operation(summary = "创建商品")
    @PostMapping("/create")
    public AjaxResult createProduct(@RequestBody PaymentDto orderDto) {

        log.info("获取商品前");
        PhotoDto photo = remotePhotoService.getPhotoById(orderDto.getPaymentId());
        log.info("获取商品后");

        OrderDto order = new OrderDto();
        order.setName(photo.getName());
        order.setPrice(BigDecimal.valueOf(100.1));

        log.info("保存订单前");
        AjaxResult result = remoteOrderService.saveOrder(order);
        log.info("保存订单后");

        return AjaxResult.success(result);
    }

}
