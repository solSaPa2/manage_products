package com.ohgiraffers.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ProductDTO {

    private int productCode;
    private String productName;
    private int categoryCode;
    private int productQuantity;
    private String productDetail;
}
