package org.zidi.map.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.zidi.map.dto.request.UpdataDriverLocationRequest;

public interface LocationService {
    boolean updateDriverLocation(UpdataDriverLocationRequest updataDriverLocationRequest);

    boolean removeDriverLocation(Long driverId);
}
