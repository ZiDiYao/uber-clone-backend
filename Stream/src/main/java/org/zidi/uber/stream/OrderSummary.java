package org.zidi.uber.stream;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderSummary {
    private String customer;
    private BigDecimal amount;

    public OrderSummary(String customer, BigDecimal amount) {
        this.customer = customer;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return customer + " - ￥" + amount;
    }

    // 也可以加 getter/setter，如果你想用 lombok 的话写 @Data 也可以
}