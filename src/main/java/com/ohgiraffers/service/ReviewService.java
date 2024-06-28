package com.ohgiraffers.service;

import com.ohgiraffers.dao.OrderMapper;
import com.ohgiraffers.dao.ReviewMapper;
import com.ohgiraffers.dto.ProductReviewDTO;
import com.ohgiraffers.dto.ReviewDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ReviewService {

    private ReviewMapper mapper;

    public int insertReview(Map<String, String> map) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ReviewMapper.class);

        int result = mapper.insertReview(map);

        if(result > 0){
            sqlSession.commit();
        } else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public boolean updateReview(ReviewDTO review) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ReviewMapper.class);

        int result = mapper.updateReview(review);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public ReviewDTO selectMyReviews(int orderId) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ReviewMapper.class);

        ReviewDTO reviewDTO = mapper.selectMyReviews(orderId);

        sqlSession.close();

        return reviewDTO;
    }

    public boolean deleteReview(int review) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ReviewMapper.class);

        int result = mapper.deleteReview(review);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public ProductReviewDTO selectReviewByProductCode(int productCode) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ReviewMapper.class);

        ProductReviewDTO productReview = mapper.selectReviewByProductCode(productCode);

        sqlSession.close();

        return productReview;
    }

    public List<ReviewDTO> selectReviewByOrderId(Map<String, String> map) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ReviewMapper.class);

        List<ReviewDTO> reviewList = mapper.selectReviewByOrderId(map);

        sqlSession.close();
        return reviewList;
    }
}