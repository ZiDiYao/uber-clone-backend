package org.zidi.order.service;

import org.zidi.order.dto.response.OrderBillResponse;
import org.zidi.order.dto.response.OrderPayResponse;

import java.math.BigDecimal;

public interface OrderPaymentService {

    OrderBillResponse getOrderBillInfo(Long orderId);
    Boolean sendOrderBillInfo(Long orderId, Long driverId);
    OrderPayResponse getOrderPayVo(String orderNo, Long customerId);
    Boolean updateOrderPayStatus(String orderNo);
    Boolean updateCouponAmount(Long orderId, BigDecimal couponAmount);
}
