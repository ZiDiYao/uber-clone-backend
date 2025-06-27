package org.zidi.map.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zidi.map.dto.request.CalculateDrivingLineFormRequest;
import org.zidi.map.dto.response.DrivingLineResponse;
import org.zidi.map.service.MapService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/map")
public class MapController {

    private final MapService mapService;

    @PostMapping("/calculateDrivingLine")
    public DrivingLineResponse calculateDrivingLine(@RequestBody CalculateDrivingLineFormRequest calculateDrivingLineFormRequest){

        return mapService.calculateDrivingLine(calculateDrivingLineFormRequest);

    }

}
