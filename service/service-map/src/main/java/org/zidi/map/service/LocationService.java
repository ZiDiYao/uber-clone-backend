package org.zidi.map.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.zidi.map.dto.request.SearchNearbyDriverRequest;
import org.zidi.map.dto.request.UpdataDriverLocationRequest;
import org.zidi.map.dto.response.NearbyDriverResponse;

import java.util.List;

public interface LocationService {
    boolean updateDriverLocation(UpdataDriverLocationRequest updataDriverLocationRequest);

    boolean removeDriverLocation(Long driverId);

    // 搜索附近满足条件的司机
    List<Long> searchNearbyDrivers(SearchNearbyDriverRequest searchNearbyDriverRequest);

}
