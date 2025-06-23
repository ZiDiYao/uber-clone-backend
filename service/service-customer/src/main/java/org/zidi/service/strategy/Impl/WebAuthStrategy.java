package org.zidi.service.strategy.Impl;

import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.entity.CustomerInfo;
import org.zidi.service.strategy.LoginStrategy;

/**
 *  Strategy Pattern
 *  A pattern for Web login with userName, password, Email, etc.
 *
 */

public class WebAuthStrategy implements LoginStrategy {

    @Override
    public boolean supports(String loginType) {
        return "WEB".equalsIgnoreCase(loginType);
    }

    @Override
    public CustomerInfo login(CustomerLoginRequest request) {
        return null;
    }
}
