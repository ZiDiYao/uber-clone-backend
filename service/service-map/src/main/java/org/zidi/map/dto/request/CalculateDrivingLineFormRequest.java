package org.zidi.map.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CalculateDrivingLineFormRequest {

    private String id;

    private Long orderId;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private Date createTime;

}
