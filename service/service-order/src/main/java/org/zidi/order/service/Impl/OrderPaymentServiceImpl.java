package org.zidi.order.service.Impl;

import org.zidi.order.dto.response.OrderBillResponse;
import org.zidi.order.dto.response.OrderPayResponse;
import org.zidi.order.service.OrderPaymentService;

import java.math.BigDecimal;

public class OrderPaymentServiceImpl implements OrderPaymentService {
    @Override
    public OrderBillResponse getOrderBillInfo(Long orderId) {
        return null;
    }

    @Override
    public Boolean sendOrderBillInfo(Long orderId, Long driverId) {
        return null;
    }

    @Override
    public OrderPayResponse getOrderPayVo(String orderNo, Long customerId) {
        return null;
    }

    @Override
    public Boolean updateOrderPayStatus(String orderNo) {
        return null;
    }

    @Override
    public Boolean updateCouponAmount(Long orderId, BigDecimal couponAmount) {
        return null;
    }
}
