package com.ohgiraffers.dao;

import com.ohgiraffers.dto.ProductReviewDTO;
import com.ohgiraffers.dto.ReviewDTO;

import java.util.List;
import java.util.Map;

public interface ReviewMapper {

    int insertReview(Map<String, String> map);

    int updateReview(ReviewDTO review);

    ReviewDTO selectMyReviews(int orderId);

    int deleteReview(int review);

    ProductReviewDTO selectReviewByProductCode(int productCode);

    List<ReviewDTO> selectReviewByOrderId(Map<String, String> map);
}