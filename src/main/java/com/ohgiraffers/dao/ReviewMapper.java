package com.ohgiraffers.dao;

import com.ohgiraffers.dto.ReviewDTO;

public interface ReviewMapper {

    int insertReview(ReviewDTO reviewDTO);

    int updateReview(ReviewDTO review);


    ReviewDTO selectMyReviews(int orderId);
}
