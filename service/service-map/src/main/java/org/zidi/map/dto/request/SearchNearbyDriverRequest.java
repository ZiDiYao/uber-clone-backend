package org.zidi.map.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SearchNearbyDriverRequest {

    private BigDecimal longitude;

    private BigDecimal latitude;

    private BigDecimal mileageDistance;
}
