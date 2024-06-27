package com.ohgiraffers.controller;

import com.ohgiraffers.dto.ReviewDTO;
import com.ohgiraffers.service.ReviewService;

import java.util.Map;

public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController() {
        reviewService = new ReviewService();
    }

    public void updateReview(Map<String, String> parameter) {

        int reviewId = Integer.parseInt(parameter.get("reviewId"));
        double rating = Double.parseDouble(parameter.get("rating"));
        String reviewDetail = parameter.get("reviewDetail");

        ReviewDTO review = new ReviewDTO();

        review.setReviewId(reviewId);
        review.setRatings(rating);
        review.setReviewDetail(reviewDetail);


        if (reviewService.updateReview(review)) {
            System.out.println("리뷰 수정을 성공했습니다!");
        } else {
            System.out.println("리뷰 수정을 실패했습니다!");
        }
    }

}
