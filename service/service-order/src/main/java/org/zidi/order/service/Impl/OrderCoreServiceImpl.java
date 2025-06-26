package org.zidi.order.service.Impl;

import org.zidi.order.dto.request.OrderInfoFormRequest;
import org.zidi.order.dto.response.CurrentOrderInfoResponse;
import org.zidi.order.service.OrderCoreService;

public class OrderCoreServiceImpl implements OrderCoreService {
    @Override
    public Long saveOrderInfo(OrderInfoFormRequest orderInfoForm) {
        return null;
    }

    @Override
    public Integer getOrderStatus(Long orderId) {
        return null;
    }

    @Override
    public CurrentOrderInfoResponse searchCustomerCurrentOrder(Long customerId) {
        return null;
    }

    @Override
    public CurrentOrderInfoResponse searchDriverCurrentOrder(Long driverId) {
        return null;
    }
}
