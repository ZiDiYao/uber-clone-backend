package org.zidi.order.service;

import org.springframework.data.domain.Page;
import org.zidi.order.dto.request.OrderInfoForm;
import org.zidi.order.dto.request.StartDriveForm;
import org.zidi.order.dto.request.UpdateOrderBillForm;
import org.zidi.order.dto.request.UpdateOrderCartForm;
import org.zidi.order.dto.response.*;
import org.zidi.order.repository.OrderInfo;

import java.math.BigDecimal;

public interface OrderInfoService {

    //乘客下单
    Long saveOrderInfo(OrderInfoForm orderInfoForm);

    //根据订单id获取订单状态
    Integer getOrderStatus(Long orderId);

    //司机抢单
    Boolean robNewOrder(Long driverId, Long orderId);

    //乘客端查找当前订单
    CurrentOrderInfoResponse searchCustomerCurrentOrder(Long customerId);

    CurrentOrderInfoResponse searchDriverCurrentOrder(Long driverId);

    Boolean driverArriveStartLocation(Long orderId, Long driverId);

    Boolean updateOrderCart(UpdateOrderCartForm updateOrderCartForm);

    Boolean startDriver(StartDriveForm startDriveForm);

    Long getOrderNumByTime(String startTime, String endTime);

    Boolean endDrive(UpdateOrderBillForm updateOrderBillForm);

    //获取乘客订单分页列表
    PageResponse findCustomerOrderPage(Page<OrderInfo> pageParam, Long customerId);

    PageResponse findDriverOrderPage(Page<OrderInfo> pageParam, Long driverId);

    OrderBillResponse getOrderBillInfo(Long orderId);

    OrderProfitsharingResponse getOrderProfitsharing(Long orderId);

    Boolean sendOrderBillInfo(Long orderId, Long driverId);

    OrderPayResponse getOrderPayVo(String orderNo, Long customerId);

    Boolean updateOrderPayStatus(String orderNo);

    OrderRewardResponse getOrderRewardFee(String orderNo);

    ////调用方法取消订单
    void orderCancel(long parseLong);

    Boolean updateCouponAmount(Long orderId, BigDecimal couponAmount);
}
