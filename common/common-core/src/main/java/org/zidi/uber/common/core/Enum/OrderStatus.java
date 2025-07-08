package org.zidi.uber.common.core.Enum;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum OrderStatus {
    WAITING(1, "Waiting for driver to accept"),
    ACCEPTED(2, "Order accepted"),
    DRIVER_ARRIVED(3, "Driver arrived"),
    STARTED(4, "Service started"),
    ENDED(5, "Service ended"),
    UNPAID(6, "Unpaid"),
    PAID(7, "Paid"),
    COMPLETED(8, "Order completed"),
    CANCELED_BY_CUSTOMER(9, "Canceled by customer"),
    CANCELED_BY_DRIVER(10, "Canceled by driver"),
    CLOSED_BY_ACCIDENT(11, "Closed due to incident"),
    OTHER(12, "Other");

    private final int code;
    private final String description;

    OrderStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    // 反查 enum
    private static final Map<Integer, OrderStatus> codeMap = new HashMap<>();

    static {
        for (OrderStatus status : OrderStatus.values()) {
            codeMap.put(status.getCode(), status);
        }
    }

    public static OrderStatus fromCode(int code) {
        OrderStatus status = codeMap.get(code);
        if (status == null) {
            throw new IllegalArgumentException("Invalid Code: " + code);
        }
        return status;
    }

}