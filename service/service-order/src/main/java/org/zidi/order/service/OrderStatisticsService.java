package org.zidi.order.service;

import org.springframework.data.domain.Page;
import org.zidi.order.dto.response.OrderProfitsharingResponse;
import org.zidi.order.dto.response.OrderRewardResponse;
import org.zidi.order.dto.response.PageResponse;
import org.zidi.order.repository.OrderInfo;

public interface OrderStatisticsService {

    Long getOrderNumByTime(String startTime, String endTime);
    PageResponse findCustomerOrderPage(Page<OrderInfo> pageParam, Long customerId);
    PageResponse findDriverOrderPage(Page<OrderInfo> pageParam, Long driverId);
    OrderProfitsharingResponse getOrderProfitsharing(Long orderId);
    OrderRewardResponse getOrderRewardFee(String orderNo);
}
