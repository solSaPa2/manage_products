package com.ohgiraffers.controller;

import com.ohgiraffers.service.OrderService;

import java.util.Map;

public class OrderController {
    private final OrderService orderService;

    public OrderController() {
        orderService = new OrderService();
    }

    public void insertOrder(Map<String, String> map) {
        int result = orderService.insertOrder(map);

        if (result > 0){
            System.out.println("주문 성공!");
        } else {
            System.out.println("주문 실패!");
        }
    }
}
