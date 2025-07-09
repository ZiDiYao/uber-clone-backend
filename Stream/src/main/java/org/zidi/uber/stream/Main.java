package org.zidi.uber.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order("A001", "Alice", new BigDecimal("300"), true),
                new Order("A002", "Bob", new BigDecimal("150"), false),
                new Order("A003", "Alice", new BigDecimal("200"), true),
                new Order("A004", "David", new BigDecimal("350"), true),
                new Order("A005", "Bob", new BigDecimal("100"), false)
        );

        // Exercise 01 筛选出所有已完成的订单（isCompleted == true）
        orders.stream()
                .filter(Order::isPaid)
                .forEach(System.out::println);

        orders.stream()
                .filter(Order -> !Order.isPaid())
                .forEach(order -> System.out.println("订单号: " + order.getOrderId() + ", 金额: " + order.getTotalAmount()));

        orders.stream()
                .filter(order -> order.isPaid())
                .filter(order -> order.getTotalAmount().compareTo(new BigDecimal("200"))>0)
                .forEach(order -> System.out.println(order));

        // 获取所有付款订单的客户名

        List<String> paidCustomerNames =
                orders.stream()
                        .filter(Order::isPaid)
                        .map(Order::getCustomerName)
                        .distinct()
                        .toList();
        System.out.println(paidCustomerNames);

        List<String> orderIds = orders.stream()
                .map(Order::getOrderId)
                .toList();

        System.out.println(orderIds);

        List<BigDecimal> amounts = orders.stream()
                .map(Order::getTotalAmount)
                .toList();

        System.out.println(amounts);


        List<String> descriptions = orders.stream()
                .map(order -> "客户 " + order.getCustomerName()
                        + " 下了订单 " + order.getOrderId()
                        + "，总金额是 ￥" + order.getTotalAmount())
                .toList();

        descriptions.forEach(System.out::println);

        List<OrderSummary> summaries = orders.stream()
                .map(order -> new OrderSummary(order.getCustomerName(), order.getTotalAmount()))
                .toList();

        summaries.forEach(System.out::println);













    }
}