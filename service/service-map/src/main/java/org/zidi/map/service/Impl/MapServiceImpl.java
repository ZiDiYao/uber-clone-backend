package org.zidi.map.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zidi.map.dto.request.CalculateDrivingLineFormRequest;
import org.zidi.map.dto.response.DrivingLineResponse;
import org.zidi.map.service.MapService;

@Service
public class MapServiceImpl implements MapService {

    public DrivingLineResponse calculateDrivingLine(CalculateDrivingLineFormRequest calculateDrivingLineFormRequest){

        return null;


    }
}
