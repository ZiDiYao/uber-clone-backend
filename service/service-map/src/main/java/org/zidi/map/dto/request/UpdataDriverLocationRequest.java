package org.zidi.map.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdataDriverLocationRequest {

    private Long driverId;

    private BigDecimal longitude;

    private BigDecimal latitude;
}
