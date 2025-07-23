package org.zidi.service.driver.service;

import org.zidi.service.driver.dto.DriverSetResponse;

public interface DriverInfoService {

    public DriverSetResponse getDriverSet(Long driverId);
}
