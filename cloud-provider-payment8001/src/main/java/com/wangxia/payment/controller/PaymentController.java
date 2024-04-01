package com.wangxia.payment.controller;

import com.wangxia.core.core.common.api.RemoteOrderService;
import com.wangxia.core.core.common.api.RemotePhotoService;
import com.wangxia.core.core.common.constant.AjaxResult;
import com.wangxia.core.core.common.dto.OrderDto;
import com.wangxia.core.core.common.dto.PaymentDto;
import com.wangxia.core.core.common.dto.PhotoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/payment")
@Tag(name = "支付端微服务",description = "支付端")
public class PaymentController {

    @Autowired
    private  RemoteOrderService remoteOrderService;

    @Autowired
    private RemotePhotoService remotePhotoService;

    @GetMapping("/get")
    public AjaxResult get(){
        PhotoDto photo = remotePhotoService.getPhotoById("1771358206665289729");
        return AjaxResult.success(photo);
    }

    @Operation(summary = "创建商品")
    @PostMapping("/create")
    public AjaxResult createProduct(@RequestBody PaymentDto orderDto) {

        AjaxResult result = null;
        try {
            log.debug("获取商品前");
            PhotoDto photo = remotePhotoService.getPhotoById(orderDto.getPaymentId());
            log.debug("获取商品后{}",photo);

//            OrderDto order = new OrderDto();
//            order.setName(photo.getName());
//            order.setPrice(BigDecimal.valueOf(100.1));
//
//            log.info("保存订单前");
//            result = remoteOrderService.saveOrder(order);
//            log.info("保存订单后");
        } catch (Exception e) {
            log.error(e.getMessage());
        }


        return AjaxResult.success(result);
    }

}
