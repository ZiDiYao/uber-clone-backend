package org.zidi.service.driver.dto;

import lombok.Data;

@Data
public class DriverSetResponse {
    private Integer id;
    private Integer driverId;
    private String service_status;
    private String accept_distance;
    private String is_auto_accept;
}

