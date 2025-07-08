package org.zidi.order.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.zidi.order.dto.request.OrderInfoFormRequest;
import org.zidi.order.dto.response.CurrentOrderInfoResponse;
import org.zidi.order.service.OrderCoreService;

@RestController
@RequestMapping("/internal/order/core")
@RequiredArgsConstructor
public class OrderCoreController {

    private final OrderCoreService orderCoreService;
    @RequestMapping("/searchCustomerCurrentOrder")
    public CurrentOrderInfoResponse searchCustomerCurrentOrder(){
        return null;
    }


    @RequestMapping("/saveOrderInfo")
    public String saveOrderInfo(@RequestBody OrderInfoFormRequest orderInfoFormRequest){

        return orderCoreService.saveOrderInfo(orderInfoFormRequest);

    }

    @GetMapping("/getOrderStatus/{orderNo}")
    public Integer getOrderStatus(@PathVariable String orderNo){
        return orderCoreService.getOrderStatus(orderNo);

    }


}
