package com.ohgiraffers.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ReviewDTO {

    private int reviewId;
    private double ratings;
    private int orderId;
    private String reviewDetail;
}
