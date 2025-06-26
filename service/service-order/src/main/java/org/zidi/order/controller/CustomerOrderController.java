package org.zidi.order.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zidi.order.dto.response.CurrentOrderInfoResponse;

@RestController
@RequestMapping("/internal/order/customer")
@RequiredArgsConstructor
public class CustomerOrderController {

    /**
     * 临时 Mocking 确保这个是唯一订单先
     * @return CurrentOrderInfoResponse
     * TODO: 后续再完善, 目前假设用户没有订单
     */
    @Operation(summary = "searching the user's currOrder")
    @GetMapping("/searchCustomerCurrentOrder")
    public CurrentOrderInfoResponse searchCustomerCurrentOrder(){

        CurrentOrderInfoResponse currentOrderInfoResponse = new CurrentOrderInfoResponse();
        currentOrderInfoResponse.setIsHasCurrentOrder(false);
        return currentOrderInfoResponse;
    }
}
