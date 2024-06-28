package com.ohgiraffers.controller;

import com.ohgiraffers.dto.*;
import com.ohgiraffers.service.OrderService;
import com.ohgiraffers.service.ReviewService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(){
        reviewService= new ReviewService();
    }

    public void insertReview(Map<String, String> map) {
        int result = reviewService.insertReview(map);

        if (result > 0){
            System.out.println("리뷰 입력 성공!");
        } else {
            System.out.println("리뷰 입력 실패!");
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

    public void selectMyReviews(Map<String, String> loginInfo) {
        OrderService orderService = new OrderService();
        List<OrdersOrderDetailDTO> ordersList = orderService.selectOrderHistory(loginInfo);

        if (ordersList.size() == 0){
            System.out.println("리뷰 내역이 없습니다.");
        } else {
            for (OrdersOrderDetailDTO orders : ordersList){
                Map<String,String> map = new HashMap<>();
                map.put("orderId", orders.getOrderId() + "");

                List<ReviewDTO> reviewList = reviewService.selectReviewByOrderId(map);
                for (ReviewDTO review : reviewList){
                    System.out.println(review);
                }
            }
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