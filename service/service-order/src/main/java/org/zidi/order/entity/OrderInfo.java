package org.zidi.order.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Schema(description = "OrderInfo")
@TableName("order_info")
public class OrderInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "Customer ID")
    private Long customerId;

    @Schema(description = "Order number")
    private String orderNo;

    @Schema(description = "Start location")
    private String startLocation;

    @Schema(description = "Longitude of start point")
    private BigDecimal startPointLongitude;

    @Schema(description = "Latitude of start point")
    private BigDecimal startPointLatitude;

    @Schema(description = "End location")
    private String endLocation;

    @Schema(description = "Longitude of end point")
    private BigDecimal endPointLongitude;

    @Schema(description = "Latitude of end point")
    private BigDecimal endPointLatitude;

    @Schema(description = "Estimated distance")
    private BigDecimal expectDistance;

    @Schema(description = "Actual distance")
    private BigDecimal realDistance;

    @Schema(description = "Estimated order amount")
    private BigDecimal expectAmount;

    @Schema(description = "Actual order amount")
    private BigDecimal realAmount;

    @Schema(description = "Customer benefit fee")
    private BigDecimal favourFee;

    @Schema(description = "Driver ID")
    private Long driverId;

    @Schema(description = "Time when driver accepted the order")
    private Date acceptTime;

    @Schema(description = "Time when driver arrived at start location")
    private Date arriveTime;

    @Schema(description = "Time when service started")
    private Date startServiceTime;

    @Schema(description = "Time when service ended")
    private Date endServiceTime;

    @Schema(description = "Time when payment was completed via WeChat")
    private Date payTime;

    @Schema(description = "Cancellation rule ID")
    private Long cancelRuleId;

    @Schema(description = "Car license plate number")
    private String carLicense;

    @Schema(description = "Car type")
    private String carType;

    @Schema(description = "Front photo of car upon arrival")
    private String carFrontUrl;

    @Schema(description = "Back photo of car upon arrival")
    private String carBackUrl;

    @Schema(description = "WeChat transaction ID")
    private String transactionId;

    @Schema(description = "Order status: 1=Waiting, 2=Accepted, 3=Driver Arrived, 4=Started, 5=Ended, 6=Unpaid, 7=Paid, 8=Completed, 9=Cancelled by Customer, 10=Cancelled by Driver, 11=Closed due to Incident, 12=Other")
    private Integer status;

    @Schema(description = "Additional order remarks")
    private String remark;

}
