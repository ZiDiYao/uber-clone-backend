package org.zidi.service.Impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zidi.config.entity.CustomerInfo;
import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.dto.response.CustomerLoginResponse;
import org.zidi.mapper.CustomerInfoMapper;
//import org.zidi.mapper.CustomerLoginLogMapper;
import org.zidi.service.CustomerAuthService;


/**
 * 实现 登入功能
 * 使用 AOP 日志 LOG
 * 实现 LOG OUT 功能
 * 实现 Register Sign Up 功能
 *
 */

@Service
public class CustomerAuthServiceImpl implements CustomerAuthService {

    @Autowired
    private WxMaService wxMaService;

    @Autowired
    private CustomerInfoMapper customerInfoMapper;

//    @Autowired
//    private CustomerLoginLogMapper customerLoginLogMapper;

    /**
     *
     * For WX Login
     * @param request
     * @return
     */

    @Override
    public CustomerLoginResponse login(CustomerLoginRequest request) {
        String code = request.getCode();
        String openId = getOpenId(code);

        CustomerInfo customerInfo = getOrCreateUser(openId);

//        recordLoginLog(customerInfo.getId());

        return buildLoginResponse(customerInfo, openId);
    }

    /**
     *
     *
     * @param user
     * @param openId
     * @return
     */

    private CustomerLoginResponse buildLoginResponse(CustomerInfo user, String openId) {
        CustomerLoginResponse response = new CustomerLoginResponse();
        response.setUserId(user.getId());
        response.setOpenId(openId);
        response.setNickname(user.getNickname());
        response.setAvatarUrl(user.getAvatarUrl());
        response.setToken("mock-token");
        response.setLoginMessage("登录成功");
        return response;
    }

//    private void recordLoginLog(Long userId) {
//        CustomerLoginLog log = new CustomerLoginLog();
//        log.setCustomerId(userId);
//        log.setMsg("小程序登录");
//        customerLoginLogMapper.insert(log);
//    }

    /**
     *
     * @param openId
     * @return CustomerInfo
     */
    private CustomerInfo getOrCreateUser(String openId) {
        CustomerInfo user = customerInfoMapper.selectByOpenId(openId);
        if (user == null) {
            user = new CustomerInfo();
            user.setWxOpenId(openId);
            user.setNickname("用户" + System.currentTimeMillis());
            user.setAvatarUrl("https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
            customerInfoMapper.insert(user);
        }
        return user;
    }

    /**
     *
     *
     * @param code
     * @return String
     */

    private String getOpenId(String code) {
        try {
            WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(code);
            return session.getOpenid();
        } catch (WxErrorException e) {
            throw new RuntimeException("获取微信 openId 失败", e);
        }
    }
}
