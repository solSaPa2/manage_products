package com.ohgiraffers.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductReviewDTO {

    private int productCode;
    private String productName;
    private int categoryCode;
    private int productQuantity;
    private String productDetail;
    private int productPrice;
    private String sellerId;

    private List<ReviewDTO> reviewList;
}
