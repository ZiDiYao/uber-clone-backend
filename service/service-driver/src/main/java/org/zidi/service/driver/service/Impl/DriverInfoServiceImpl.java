package org.zidi.service.driver.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zidi.service.driver.dto.DriverSetResponse;
import org.zidi.service.driver.mapper.DriverSetMapper;
import org.zidi.service.driver.service.DriverInfoService;

@Service
@RequiredArgsConstructor
public class DriverInfoServiceImpl implements DriverInfoService {

    private final DriverSetMapper driverSetMapper;

    /**
     * 通过 driverid 去获取 driver 的信息
     * @param driverId
     * @return
     */
    @Override
    public DriverSetResponse getDriverSet(Long driverId) {
        return driverSetMapper.selectByDriverId(driverId);
    }
}
