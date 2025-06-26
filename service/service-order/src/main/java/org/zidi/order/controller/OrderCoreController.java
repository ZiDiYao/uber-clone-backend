package org.zidi.order.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zidi.order.dto.response.CurrentOrderInfoResponse;

@RestController
@RequestMapping("/internal/order/core")
@RequiredArgsConstructor
public class OrderCoreController {
    @RequestMapping("/searchCustomerCurrentOrder")
    public CurrentOrderInfoResponse searchCustomerCurrentOrder(){
        return null;
    }
}
