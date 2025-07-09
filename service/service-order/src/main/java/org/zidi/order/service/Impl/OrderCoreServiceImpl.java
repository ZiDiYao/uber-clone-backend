package org.zidi.order.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.zidi.order.dto.request.OrderInfoFormRequest;
import org.zidi.order.dto.response.CurrentOrderInfoResponse;
import org.zidi.order.mapper.OrderInfoMapper;
import org.zidi.order.entity.OrderInfo;
import org.zidi.order.service.OrderCoreService;
import org.zidi.uber.common.core.Enum.OrderStatus;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderCoreServiceImpl implements OrderCoreService {

    private final OrderInfoMapper orderInfoMapper;

    /**
     *
     * Customer starts an order, then save the orderInfo into DATABASE
     * @param orderInfoForm
     * @return
     */
    @Override
    public String saveOrderInfo(OrderInfoFormRequest orderInfoForm) {
        OrderInfo orderInfo = convertToEntity(orderInfoForm);

        // Insert into dataBase
        orderInfoMapper.insertOrder(orderInfo);
        // return the ID if success
        return orderInfo.getOrderNo();
    }

    private String generateOrderNo(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);
        return uuid;
    }

    private OrderInfo convertToEntity(OrderInfoFormRequest form) {
        OrderInfo entity = new OrderInfo();
        entity.setCustomerId(form.getCustomerId());
        entity.setOrderNo(form.getOrderNo());
        entity.setStartLocation(form.getStartLocation());
        entity.setStartPointLongitude(form.getStartPointLongitude());
        entity.setStartPointLatitude(form.getStartPointLatitude());
        entity.setEndLocation(form.getEndLocation());
        entity.setEndPointLongitude(form.getEndPointLongitude());
        entity.setEndPointLatitude(form.getEndPointLatitude());
        entity.setFavourFee(form.getFavourFee());
        entity.setRemark(form.getRemark());
        entity.setExpectAmount(form.getExpectAmount());
        entity.setExpectDistance(form.getExpectDistance());
        // 设置后端生成的字段
        entity.setStatus(OrderStatus.WAITING.getCode());
        entity.setOrderNo(generateOrderNo()); // 假设你有这个方法
        entity.setAcceptTime(null); // 还没接单
        return entity;
    }

    @Override
    public String getOrderStatus(String orderNo) {
        String status = orderInfoMapper.getStatusByOrderNo(orderNo);
        if (status == null) {
            // 可以抛异常 / 返回默认值 / 返回提示
            throw new RuntimeException("The order does not exits：" + orderNo);
            // 或者：return "NOT_FOUND";
        }
        return status;
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
