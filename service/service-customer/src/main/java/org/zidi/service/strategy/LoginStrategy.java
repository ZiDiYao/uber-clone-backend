package org.zidi.service.strategy;

import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.entity.CustomerInfo;

public interface LoginStrategy {
    boolean supports(String loginType); // eg: "WECHAT"
    CustomerInfo login(CustomerLoginRequest request);
}
