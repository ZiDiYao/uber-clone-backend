package org.zidi.service.driver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.Mapping;
import org.zidi.service.driver.dto.DriverSetResponse;

import java.util.List;

/**
 * 用于操作 Driver ID 的
 */

@Mapper
public interface DriverSetMapper {
    DriverSetResponse selectByDriverId(@Param("driverId") Long driverId);

}
