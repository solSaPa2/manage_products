package com.ohgiraffers.service;

import com.ohgiraffers.dao.ProductMapper;
import com.ohgiraffers.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ProductService {

    private ProductMapper mapper;

    public boolean insertProduct(ProductDTO productDTO) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ProductMapper.class);

        int result = mapper.insertProduct(productDTO);

        if(result >0 ){
            sqlSession.commit();
        } else{
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;
    }
}
