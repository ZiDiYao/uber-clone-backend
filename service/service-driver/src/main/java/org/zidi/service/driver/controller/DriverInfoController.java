package org.zidi.service.driver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zidi.service.driver.dto.DriverSetResponse;

@RestController
@RequestMapping("/internal/driver/info")
public class DriverInfoController {

    /**
     *
     * 根据司机 ID 去查询 司机个性化设置 比如
     * 接受多少公里内的接单 3 km 还是 5km ?
     * 还有比如 是否要求自动接单等
     * @param DriverId
     * @return
     */
    @GetMapping("/getDriverSet/{DriverId}")
    public DriverSetResponse getDriverSet(@PathVariable Long DriverId){


        return null;


    }


}
