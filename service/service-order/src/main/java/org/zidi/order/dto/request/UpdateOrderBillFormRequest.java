package org.zidi.order.dto.request;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

@Data
@Schema(description = "Order Billing Form")
public class UpdateOrderBillFormRequest {

    @Schema(description = "Order ID")
    private Long orderId;

    @Schema(description = "Driver ID")
    private Long driverId;

    @Schema(description = "Actual distance traveled")
    private BigDecimal realDistance;

    // Additional fees: tolls, parking, other charges, customer benefit fee
    @Schema(description = "Toll fee")
    private BigDecimal tollFee;

    @Schema(description = "Parking fee")
    private BigDecimal parkingFee;

    @Schema(description = "Other fees")
    private BigDecimal otherFee;

    @Schema(description = "Customer benefit fee")
    private BigDecimal favourFee;

    // Order reward related properties
    @Schema(description = "Reward rule ID")
    private Long rewardRuleId;

    @Schema(description = "Reward amount")
    private BigDecimal rewardAmount;

    // Ride service fee-related properties
    @Schema(description = "Fee rule ID")
    private Long feeRuleId;

    @Schema(description = "Total amount")
    private BigDecimal totalAmount;

    @Schema(description = "Base distance (km)")
    private BigDecimal baseDistance;

    @Schema(description = "Base distance fee (CNY)")
    private BigDecimal baseDistanceFee;

    @Schema(description = "Exceeded distance beyond base (km)")
    private BigDecimal exceedDistance;

    @Schema(description = "Price per km for exceeded distance (CNY/km)")
    private BigDecimal exceedDistancePrice;

    @Schema(description = "Base waiting time (minutes)")
    private Integer baseWaitMinute;

    @Schema(description = "Exceeded waiting time (minutes)")
    private Integer exceedWaitMinute;

    @Schema(description = "Price per minute for exceeded waiting time (CNY/min)")
    private BigDecimal exceedWaitMinutePrice;

    @Schema(description = "Base long-distance mileage (km)")
    private BigDecimal baseLongDistance;

    @Schema(description = "Exceeded long-distance mileage (km)")
    private BigDecimal exceedLongDistance;

    @Schema(description = "Price per km for exceeded long-distance (CNY/km)")
    private BigDecimal exceedLongDistancePrice;

    // Order profit-sharing properties
    @Schema(description = "Profit-sharing rule ID")
    private Long profitsharingRuleId;

    @Schema(description = "Order amount")
    private BigDecimal orderAmount;

    @Schema(description = "WeChat Pay platform fee rate")
    private BigDecimal paymentRate;

    @Schema(description = "WeChat Pay platform fee")
    private BigDecimal paymentFee;

    @Schema(description = "Driver personal income tax rate")
    private BigDecimal driverTaxRate;

    @Schema(description = "Driver tax deduction amount")
    private BigDecimal driverTaxFee;

    @Schema(description = "Platform income from profit-sharing")
    private BigDecimal platformIncome;

    @Schema(description = "Driver income from profit-sharing")
    private BigDecimal driverIncome;
}
