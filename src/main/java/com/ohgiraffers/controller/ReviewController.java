package com.ohgiraffers.controller;

import com.ohgiraffers.dto.OrderDetailDTO;
import com.ohgiraffers.dto.ProductDTO;
import com.ohgiraffers.dto.ReviewDTO;
import com.ohgiraffers.service.ReviewService;

import java.util.Map;

public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(){
        reviewService= new ReviewService();
    }

    public void insertReview(Map<String, String> parameter) {


        double ratings= Double.parseDouble(parameter.get("ratings"));
        String reviewDetail = parameter.get("reviewDetail");
        int productCode = Integer.parseInt(parameter.get("productCode"));
        int orderId = Integer.parseInt(parameter.get("orderId"));

        ReviewDTO review = new ReviewDTO();


        review.setRatings(ratings);
        review.setReviewDetail(reviewDetail);
        review.setOrderId(orderId);
        review.setProductCode(productCode);

        if(reviewService.insertReview(review)) {
            System.out.println("추가 성공");
        } else {
            System.out.println("추가 실패");
        }

    }

    public void updateReview(Map<String, String> parameter) {

        int reviewId = Integer.parseInt(parameter.get("reviewId"));
        double ratings = Double.parseDouble(parameter.get("ratings"));
        int orderId = Integer.parseInt(parameter.get("orderId"));
        String reviewDetail = parameter.get("reviewDetail");

        ReviewDTO review = new ReviewDTO();

        review.setReviewId(reviewId);
        review.setRatings(ratings);
        review.setOrderId(orderId);
        review.setReviewDetail(reviewDetail);


        if (reviewService.updateReview(review)) {
            System.out.println("리뷰 수정을 성공했습니다!");
        } else {
            System.out.println("리뷰 수정을 실패했습니다!");
        }
    }

    public void selectMyReviews(Map<String, String> parameter) {

        int orderId = Integer.parseInt(parameter.get("orderId"));

        ReviewDTO reviewDTO =reviewService.selectMyReviews(orderId);

        if( reviewDTO != null) {
            System.out.println(reviewDTO);
        } else {
            System.out.println("단일 조회 실패");
        }
    }
}
