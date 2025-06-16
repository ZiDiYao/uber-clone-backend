package org.zidi.service;

import org.zidi.dto.request.CustomerInfoRequest;
import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.dto.response.CustomerInfoResponse;

public interface CustomerInfoService {

    public CustomerInfoResponse getCustomerInfo(CustomerInfoRequest customerLoginRequest);

}
