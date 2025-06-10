package org.zidi.service;

import me.chanjar.weixin.common.error.WxErrorException;
import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.dto.response.CustomerLoginResponse;

public interface CustomerAuthService {

    public CustomerLoginResponse login(CustomerLoginRequest code) throws WxErrorException;
}
