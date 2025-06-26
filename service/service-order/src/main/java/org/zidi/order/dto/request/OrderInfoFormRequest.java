package org.zidi.order.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderInfoFormRequest {

    @Schema(description = "Customer ID")
    private Long customerId;

    @Schema(description = "Order number")
    private String orderNo;

    @Schema(description = "Start location")
    private String startLocation;

    @Schema(description = "Longitude of the start point")
    private BigDecimal startPointLongitude;

    @Schema(description = "Latitude of the start point")
    private BigDecimal startPointLatitude;

    @Schema(description = "End location")
    private String endLocation;

    @Schema(description = "Longitude of the end point")
    private BigDecimal endPointLongitude;

    @Schema(description = "Latitude of the end point")
    private BigDecimal endPointLatitude;

    @Schema(description = "Customer benefit fee")
    private BigDecimal favourFee;

    @Schema(description = "Additional remarks for the order")
    private String remark;

    // Expected trip details
    @Schema(description = "Estimated total cost")
    private BigDecimal expectAmount;

    @Schema(description = "Estimated distance")
    private BigDecimal expectDistance;
}
