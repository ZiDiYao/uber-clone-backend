package org.zidi.order.dto.request;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Update Order Vehicle Form")
public class UpdateOrderCartFormRequest {

    @Schema(description = "Order ID")
    private Long orderId;

    @Schema(description = "Driver ID")
    private Long driverId;

    @Schema(description = "License plate number")
    @TableField("car_license")
    private String carLicense;

    @Schema(description = "Car type/model")
    @TableField("car_type")
    private String carType;

    @Schema(description = "Driver arrival photo: front view of the car")
    @TableField("car_front_url")
    private String carFrontUrl;

    @Schema(description = "Driver arrival photo: rear view of the car")
    @TableField("car_back_url")
    private String carBackUrl;
}
