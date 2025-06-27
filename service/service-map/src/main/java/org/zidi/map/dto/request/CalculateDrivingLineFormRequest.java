package org.zidi.map.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CalculateDrivingLineFormRequest {

    private BigDecimal startPointLongitude;

    private BigDecimal startPointLatitude;

    private BigDecimal endPointLongitude;

    private BigDecimal endPointLatitude;

}
