package org.zidi.map.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.zidi.map.dto.request.SearchNearbyDriverRequest;
import org.zidi.map.dto.request.UpdataDriverLocationRequest;
import org.zidi.map.service.LocationService;
import org.zidi.uber.common.core.constant.RedisConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final RedisTemplate<String, String> redisTemplate;

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

    @Override
    public List<Long> searchNearbyDrivers(SearchNearbyDriverRequest searchNearbyDriverRequest) {
        // 搜索经纬度这个位置中 5km 以内的司机
        // 1. redis GEO
        Point point = new Point(searchNearbyDriverRequest.getLongitude().doubleValue(),searchNearbyDriverRequest.getLatitude().doubleValue());
        Distance distance = new Distance(5, Metrics.KILOMETERS);
        Circle circle = new Circle(point,distance);
        // 定义 GEO 相关的参数
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs()
                .includeDistance()
                .includeCoordinates() // 包含坐标
                .sortAscending();
        GeoResults<RedisGeoCommands.GeoLocation<String>> result= redisTemplate.opsForGeo().radius(RedisConstant.GEO_DRIVER_LOCATION,circle,args);

        // 2. redis GEO redis
        assert result != null;
        List<GeoResult<RedisGeoCommands.GeoLocation<String>>> content = result.getContent();

        // 3. we can get a list with several drivers
        // 4. 调用 filterNearbyDrivers
        return filterNearbyDrivers(content);
    }

    private List<Long> filterNearbyDrivers(List<GeoResult<RedisGeoCommands.GeoLocation<String>>> nearbyDrivers){
        if (CollectionUtils.isEmpty(nearbyDrivers)) return Collections.emptyList();

        return nearbyDrivers.stream()
                .map(item -> Long.parseLong(item.getContent().getName()))
                .collect(Collectors.toList());
    }

}
