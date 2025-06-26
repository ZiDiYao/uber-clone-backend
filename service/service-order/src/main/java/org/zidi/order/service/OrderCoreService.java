package org.zidi.order.service;

import org.zidi.order.dto.request.OrderInfoFormRequest;
import org.zidi.order.dto.response.CurrentOrderInfoResponse;

public interface OrderCoreService {

    Long saveOrderInfo(OrderInfoFormRequest orderInfoForm);
    Integer getOrderStatus(Long orderId);
    CurrentOrderInfoResponse searchCustomerCurrentOrder(Long customerId);
    CurrentOrderInfoResponse searchDriverCurrentOrder(Long driverId);
}
