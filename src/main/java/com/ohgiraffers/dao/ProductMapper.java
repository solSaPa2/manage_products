package com.ohgiraffers.dao;

import com.ohgiraffers.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface ProductMapper {

    List<ProductDTO> selectAllProduct();



}
