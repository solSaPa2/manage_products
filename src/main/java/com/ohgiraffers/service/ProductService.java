package com.ohgiraffers.service;

import com.ohgiraffers.dao.ProductMapper;
import com.ohgiraffers.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ProductService {

    private ProductMapper mapper;

    public List<ProductDTO> selectAllProducts() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ProductMapper.class);

        List<ProductDTO> productList = mapper.selectAllProduct();

        for(ProductDTO productDTO : productList){
            System.out.println(productDTO);
        }

        sqlSession.close();
        return productList;
    }

    public List<ProductDTO> deleteProduct(){

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ProductMapper.class);

        List<ProductDTO> productList = mapper.deleteProduct();

        for(ProductDTO productDTO : productList){
            System.out.println(productDTO);
        }

        sqlSession.close();
        return deleteProduct();
    }



}
