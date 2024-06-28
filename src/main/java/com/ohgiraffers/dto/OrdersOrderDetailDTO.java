package com.ohgiraffers.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrdersOrderDetailDTO {
    private int orderId;
    private Date orderTime;
    private int totalPrice;
    private String memberId;

    private List<OrderDetailDTO> orderDetailList;
}
