package org.zidi.map.service;

import org.zidi.map.dto.request.CalculateDrivingLineFormRequest;
import org.zidi.map.dto.response.DrivingLineResponse;

public interface MapService {

    DrivingLineResponse calculateDrivingLine(CalculateDrivingLineFormRequest calculateDrivingLineFormRequest);
}
