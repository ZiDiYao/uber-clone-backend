package org.zidi.order.service.Impl;

import org.springframework.data.domain.Page;
import org.zidi.order.dto.request.OrderInfoForm;
import org.zidi.order.dto.request.StartDriveForm;
import org.zidi.order.dto.request.UpdateOrderBillForm;
import org.zidi.order.dto.request.UpdateOrderCartForm;
import org.zidi.order.dto.response.*;
import org.zidi.order.repository.OrderInfo;
import org.zidi.order.service.OrderInfoService;

import java.math.BigDecimal;

public class OrderInfoServiceImpl implements OrderInfoService {
    @Override
    public Long saveOrderInfo(OrderInfoForm orderInfoForm) {
        return null;
    }

    @Override
    public Integer getOrderStatus(Long orderId) {
        return null;
    }

    @Override
    public Boolean robNewOrder(Long driverId, Long orderId) {
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

    @Override
    public Boolean driverArriveStartLocation(Long orderId, Long driverId) {
        return null;
    }

    @Override
    public Boolean updateOrderCart(UpdateOrderCartForm updateOrderCartForm) {
        return null;
    }

    @Override
    public Boolean startDriver(StartDriveForm startDriveForm) {
        return null;
    }

    @Override
    public Long getOrderNumByTime(String startTime, String endTime) {
        return null;
    }

    @Override
    public Boolean endDrive(UpdateOrderBillForm updateOrderBillForm) {
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
    public OrderBillResponse getOrderBillInfo(Long orderId) {
        return null;
    }

    @Override
    public OrderProfitsharingResponse getOrderProfitsharing(Long orderId) {
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
    public OrderRewardResponse getOrderRewardFee(String orderNo) {
        return null;
    }

    @Override
    public void orderCancel(long parseLong) {

    }

    @Override
    public Boolean updateCouponAmount(Long orderId, BigDecimal couponAmount) {
        return null;
    }
}
