package org.zidi.rules.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FeeRuleResponse {

    private BigDecimal totalAmount;

    private BigDecimal distanceFee;

    private BigDecimal waitFee;

    private BigDecimal longDistanceFee;

    private BigDecimal baseDistance;

    private BigDecimal baseDistanceFee;

    private BigDecimal exceedDistance;

    private BigDecimal exceedDistancePrice;

    private Integer baseWaitMinute;

    private Integer exceedWaitMinute;

    private BigDecimal exceedWaitMinutePrice;

    private BigDecimal baseLongDistance;

    private BigDecimal exceedLongDistance;

    private BigDecimal exceedLongDistancePrice;
}