package org.zidi.order.dto.request;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;


@Data
@Schema(description = "Start Drive Form")
public class StartDriveFormRequest {

    @Schema(description = "Order ID")
    private Long orderId;

    @Schema(description = "Driver ID")
    private Long driverId;
}
