package org.zidi.map.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.zidi.map.dto.request.UpdataDriverLocationRequest;
import org.zidi.map.service.LocationService;
import org.zidi.uber.common.core.constant.RedisConstant;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean updateDriverLocation(UpdataDriverLocationRequest updataDriverLocationRequest) {
        // 把司机的位置信息要放进 Redis GEO 里
        Point point = new Point(updataDriverLocationRequest.getLongitude().doubleValue(),
                updataDriverLocationRequest.getLatitude().doubleValue());

        redisTemplate.opsForGeo().add(RedisConstant.GEO_DRIVER_LOCATION,
                point,
                updataDriverLocationRequest.getDriverId().toString());
        return true;
    }
    @Override
    public boolean removeDriverLocation(Long driverId) {
        // 删除司机的位置信息
        redisTemplate.opsForGeo().remove(RedisConstant.GEO_DRIVER_LOCATION,driverId.toString());
        return true;
    }
}
