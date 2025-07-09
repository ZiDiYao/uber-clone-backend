package org.zidi.map.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.zidi.map.dto.request.UpdataDriverLocationRequest;
import org.zidi.map.service.LocationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/location")
public class LocationController {

    private final LocationService locationService;

    // 司机开启接单后,更新司机信息

    /**
     *
     * 更新司机的经纬度信息
     * @param updataDriverLocationRequest
     * @return
     */
    @PostMapping("updateDriverLocation")
    public boolean updateDriverLocation(@RequestBody UpdataDriverLocationRequest updataDriverLocationRequest){
        return locationService.updateDriverLocation(updataDriverLocationRequest);
    }

    // 司机关闭接口后, 关闭司机位置共享
    // DeleteMapping 这个接口用来删除资源
    @DeleteMapping("/removeDriverLocation/{driverId}")
    public boolean removeDriverLocation(@PathVariable Long driverId){
        return locationService.removeDriverLocation(driverId);
    }





}
