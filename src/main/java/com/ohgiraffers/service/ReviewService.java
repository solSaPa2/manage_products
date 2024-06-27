package com.ohgiraffers.service;

import com.ohgiraffers.dao.ProductMapper;
import com.ohgiraffers.dao.ReviewMapper;
import com.ohgiraffers.dto.ReviewDTO;
import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ReviewService {

    private ReviewMapper Mapper;

    public boolean insertReview(ReviewDTO reviewDTO) {
        SqlSession sqlSession = getSqlSession();
        Mapper = sqlSession.getMapper(ReviewMapper.class);

        System.out.println(reviewDTO);
        int result =Mapper.insertReview(reviewDTO);

        if(result >0 ){
            sqlSession.commit();
        } else{
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;
    }

    public boolean updateReview(ReviewDTO review) {

        SqlSession sqlSession = getSqlSession();

        Mapper = sqlSession.getMapper(ReviewMapper.class);

        int result = Mapper.updateReview(review);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
