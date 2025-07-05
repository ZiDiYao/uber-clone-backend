package org.zidi.rules.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FeeRuleRequest {

    private BigDecimal distance;
    private String startTime;
    private Integer waitMinute;

}