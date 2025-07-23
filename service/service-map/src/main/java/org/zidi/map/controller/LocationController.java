package org.zidi.map.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.zidi.map.dto.request.SearchNearbyDriverRequest;
import org.zidi.map.dto.request.UpdataDriverLocationRequest;
import org.zidi.map.service.LocationService;

import java.util.List;

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

    /**
     *  只用于返回给上一层,返回了 5km 内的 driver id
     *  更高层的 layer 需要去 筛选 filter 使用其他 module feign 去筛选不同 driver 的 preferences
     *  当然了, 算法有改进空间, 这样似乎效率毕竟低
     * @param searchNearbyDriverRequest
     * @return
     */

    @PostMapping("/searchNearbyDriver")
    public List<Long> searchNearbyDriver(@RequestBody SearchNearbyDriverRequest searchNearbyDriverRequest){
        return locationService.searchNearbyDrivers(searchNearbyDriverRequest);
    }


}
