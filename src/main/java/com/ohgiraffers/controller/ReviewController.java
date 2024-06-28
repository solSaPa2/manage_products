package com.ohgiraffers.controller;

import com.ohgiraffers.dto.ProductDTO;
import com.ohgiraffers.dto.ProductReviewDTO;
import com.ohgiraffers.dto.ReviewDTO;
import com.ohgiraffers.service.ReviewService;

import java.util.Map;

public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(){

        reviewService= new ReviewService();
    }

    public void insertReview(Map<String, String> parameter) {


        int productCode = Integer.parseInt(parameter.get("productCode"));
        double ratings= Double.parseDouble(parameter.get("ratings"));
        String reviewDetail = parameter.get("reviewDetail");

        ReviewDTO review = new ReviewDTO();

        review.setOrderId(productCode);
        review.setRatings(ratings);
        review.setReviewDetail(reviewDetail);

        if(reviewService.insertReview(review)) {
            System.out.println("추가 성공");
        } else {
            System.out.println("추가 실패");
        }

    }

    public void updateReview(Map<String, String> parameter) {

        int reviewId = Integer.parseInt(parameter.get("reviewId"));
        double ratings = Double.parseDouble(parameter.get("ratings"));
        String reviewDetail = parameter.get("reviewDetail");

        ReviewDTO review = new ReviewDTO();

        review.setReviewId(reviewId);
        review.setRatings(ratings);
        review.setReviewDetail(reviewDetail);


        if (reviewService.updateReview(review)) {
            System.out.println("리뷰 수정을 성공했습니다!");
        } else {
            System.out.println("리뷰 수정을 실패했습니다!");
        }
    }

    public void selectMyReviews(Map<String, String> parameter) {

        int orderId = Integer.parseInt(parameter.get("orderId"));

        ReviewDTO reviewDTO = reviewService.selectMyReviews(orderId);

        if( reviewDTO != null) {
            System.out.println(reviewDTO);
        } else {
            System.out.println("단일 조회 실패");
        }
    }

    public void deleteReview(Map<String, String> parameter) {

        int reviewId = Integer.parseInt(parameter.get("reviewId"));

        if (reviewService.deleteReview(reviewId)) {
            System.out.println("리뷰 삭제를 성공했습니다!");
        } else {
            System.out.println("리뷰 삭제를 실패했습니다!");
        }
    }

    public void selectReviewByProductCode(Map<String, String> parameter) {

        int productCode = Integer.parseInt(parameter.get("productCode"));

        ProductDTO product = new ProductDTO();

        product.setProductCode(productCode);

        ProductReviewDTO productReview = reviewService.selectReviewByProductCode(productCode);

        if (productReview != null) {

            for (ReviewDTO review : productReview.getReviewList()) {

                System.out.println("[reviewId] = " + review.getReviewId() + ", 별점 " + review.getRatings() + ", review : " + review.getReviewDetail());
            }

        } else {
            System.out.println("리뷰가 존재하지 않습니다.");
        }
    }
}