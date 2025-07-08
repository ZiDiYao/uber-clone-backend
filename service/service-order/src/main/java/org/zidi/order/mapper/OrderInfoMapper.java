package org.zidi.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zidi.order.entity.OrderInfo;

import java.util.List;

@Mapper
public interface OrderInfoMapper {
    int insertOrder(OrderInfo orderInfo);
    OrderInfo selectById(Long id);
    List<OrderInfo> selectAll();
    int updateOrder(OrderInfo orderInfo);
    int deleteById(Long id);
}