package org.zidi.order.service.Impl;

import org.springframework.data.domain.Page;
import org.zidi.order.dto.response.OrderProfitsharingResponse;
import org.zidi.order.dto.response.OrderRewardResponse;
import org.zidi.order.dto.response.PageResponse;
import org.zidi.order.entity.OrderInfo;
import org.zidi.order.service.OrderStatisticsService;

public class OrderStatisticsServiceImpl implements OrderStatisticsService {
    @Override
    public Long getOrderNumByTime(String startTime, String endTime) {
        return null;
    }

    @Override
    public PageResponse findCustomerOrderPage(Page<OrderInfo> pageParam, Long customerId) {
        return null;
    }

    @Override
    public PageResponse findDriverOrderPage(Page<OrderInfo> pageParam, Long driverId) {
        return null;
    }

    @Override
    public OrderProfitsharingResponse getOrderProfitsharing(Long orderId) {
        return null;
    }

    @Override
    public OrderRewardResponse getOrderRewardFee(String orderNo) {
        return null;
    }
}
