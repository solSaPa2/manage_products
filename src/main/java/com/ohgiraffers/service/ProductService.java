package com.ohgiraffers.service;

import com.ohgiraffers.dao.ProductMapper;
import com.ohgiraffers.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ProductService {

    private ProductMapper productMapper;

    public List<ProductDTO> selectAllProducts() {

        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);

        List<ProductDTO> productList = productMapper.selectAllProduct();

        sqlSession.close();

        return productList;
    }

}
