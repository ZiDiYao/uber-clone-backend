package org.zidi.service.strategy.Impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.entity.CustomerInfo;
import org.zidi.mapper.CustomerInfoMapper;
import org.zidi.service.strategy.LoginStrategy;
import java.time.LocalDateTime;
import org.zidi.uber.common.thirdparty.WeiXin.WxAuthUtil;


@Service
@RequiredArgsConstructor
public class WxMiniProgramAuthStrategy implements LoginStrategy {

    private final WxMaService wxMaService;
    private final CustomerInfoMapper customerInfoMapper;
    private final WxAuthUtil wxAuthUtil;

    @Override
    public boolean supports(String loginType) {
        return "WECHAT".equalsIgnoreCase(loginType);
    }

    @Override
    public CustomerInfo login(CustomerLoginRequest request) {
        String code = request.getCode();
        String openId = wxAuthUtil.getOpenId(code);

        // 复用你的 getOrCreateUser 逻辑
        CustomerInfo user = customerInfoMapper.selectOne(
                new LambdaQueryWrapper<CustomerInfo>()
                        .eq(CustomerInfo::getWxOpenId, openId)
                        .eq(CustomerInfo::getIsDeleted, 0)
        );

        if (user == null) {
            user = new CustomerInfo();
            user.setWxOpenId(openId);
            user.setNickname("用户" + System.currentTimeMillis());
            user.setAvatarUrl("https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
            user.setGender("1");
            user.setStatus(1);
            user.setIsDeleted(0);
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            customerInfoMapper.insert(user);
        }

        return user;
    }

}
