package org.zidi.order.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CurrentOrderInfoResponse {
    @Schema(description = "Order id")
    private Long orderId;

    @Schema(description = "order status")
    private Integer status;

    @Schema(description = "curr order information")
    private Boolean isHasCurrentOrder;

}
