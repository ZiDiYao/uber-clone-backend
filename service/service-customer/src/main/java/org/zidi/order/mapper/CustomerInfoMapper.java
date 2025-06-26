package org.zidi.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.zidi.entity.CustomerInfo;


@Mapper
public interface CustomerInfoMapper extends BaseMapper<CustomerInfo> {

    CustomerInfo selectByOpenId(String openId);
}