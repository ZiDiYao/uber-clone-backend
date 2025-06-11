package org.zidi.service.Impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zidi.entity.CustomerInfo;
import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.dto.response.CustomerLoginResponse;
import org.zidi.mapper.CustomerInfoMapper;
import org.zidi.service.CustomerAuthService;

import java.time.LocalDateTime;

@Service
public class CustomerAuthServiceImpl implements CustomerAuthService {

    @Autowired
    private WxMaService wxMaService;

    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    @Override
    public CustomerLoginResponse login(CustomerLoginRequest request) {
        String code = request.getCode();
        String openId = getOpenId(code);
        CustomerInfo customerInfo = getOrCreateUser(openId);
        return buildLoginResponse(customerInfo, openId);
    }

    private CustomerLoginResponse buildLoginResponse(CustomerInfo user, String openId) {
        CustomerLoginResponse response = new CustomerLoginResponse();
        response.setUserId(user.getId());
        response.setOpenId(openId);
        response.setNickname(user.getNickname());
        response.setAvatarUrl(user.getAvatarUrl());
        response.setToken("mock-token"); // TODO: 替换为真正的 JWT token
        response.setLoginMessage("登录成功");
        return response;
    }

    private CustomerInfo getOrCreateUser(String openId) {
        CustomerInfo user = customerInfoMapper.selectOne(
                new LambdaQueryWrapper<CustomerInfo>()
                        .eq(CustomerInfo::getWxOpenId, openId)
                        .eq(CustomerInfo::getIsDeleted, 0) // 逻辑删除处理
        );

        if (user == null) {
            user = new CustomerInfo();
            user.setWxOpenId(openId);
            user.setNickname("用户" + System.currentTimeMillis());
            user.setAvatarUrl("https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
            user.setGender("1");
            user.setStatus(1);
            user.setIsDeleted(0);
            user.setCreateTime(LocalDateTime.now());  // 若没配置自动填充
            user.setUpdateTime(LocalDateTime.now());
            customerInfoMapper.insert(user);
        }
        return user;
    }

    /**
     *
     *  Just for mocking purpose
     * @param code
     * @return
     */

    // mocking
    private String getOpenId(String code) {
        if ("mock".equals(code)) {
            return "mock-openid-123456";
        }

        try {
            WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(code);
            return session.getOpenid();
        } catch (WxErrorException e) {
            throw new RuntimeException("获取微信 openId 失败", e);
        }
    }


//    private String getOpenId(String code) {
//        try {
//            WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(code);
//            return session.getOpenid();
//        } catch (WxErrorException e) {
//            throw new RuntimeException("获取微信 openId 失败", e);
//        }
//    }
}
