package com.ohgiraffers.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailDTO {
    private int orderId;
    private int productCode;
    private int quantity;
}
