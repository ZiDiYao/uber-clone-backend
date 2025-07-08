package org.zidi.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zidi.entity.CustomerInfo;
import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.dto.response.CustomerLoginResponse;
import org.zidi.service.CustomerAuthService;
import org.zidi.service.strategy.LoginStrategy;
import org.zidi.uber.common.auth.TokenService;
import org.zidi.uber.common.core.BusinessException;
import org.zidi.uber.common.core.Enum.ErrorCode;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerAuthServiceImpl implements CustomerAuthService {

    private final List<LoginStrategy> loginStrategies;
    private final TokenService tokenService;

    @Override
    public CustomerLoginResponse login(CustomerLoginRequest request) {
        LoginStrategy strategy = getLoginStrategy(request.getLoginType());

        CustomerInfo user = strategy.login(request);

        log.info("User login successful. User ID: {}, Login type: {}", user.getId(), request.getLoginType());

        return buildLoginResponse(user);
    }

    /**
     * Find the login strategy based on the login type
     */
    private LoginStrategy getLoginStrategy(String loginType) {
        return loginStrategies.stream()
                .filter(s -> s.supports(loginType))
                .findFirst()
                .orElseThrow(() -> {
                    log.warn("Unsupported login type: {}", loginType);
                    return new BusinessException(ErrorCode.UNAUTHORIZED, "Unsupported login type: " + loginType);
                });
    }

    /**
     * Build the login response object
     */
    private CustomerLoginResponse buildLoginResponse(CustomerInfo user) {
        String token = tokenService.generateToken(user.getId());

        CustomerLoginResponse response = new CustomerLoginResponse();
        response.setUserId(user.getId());
        response.setNickname(user.getNickname());
        response.setAvatarUrl(user.getAvatarUrl());
        response.setToken(token);
        response.setLoginMessage("Login successful");
        return response;
    }
}
