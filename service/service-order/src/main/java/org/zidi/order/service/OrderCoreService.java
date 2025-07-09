package org.zidi.order.service;

import org.zidi.order.dto.request.OrderInfoFormRequest;
import org.zidi.order.dto.response.CurrentOrderInfoResponse;

public interface OrderCoreService {

    String saveOrderInfo(OrderInfoFormRequest orderInfoForm);
    String getOrderStatus(String orderId);
    CurrentOrderInfoResponse searchCustomerCurrentOrder(Long customerId);
    CurrentOrderInfoResponse searchDriverCurrentOrder(Long driverId);


}
