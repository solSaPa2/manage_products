package com.ohgiraffers.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrdersDTO {
    private int orderId;
    private Date orderTime;
    private int totalPrice;
    private String memberId;
}
