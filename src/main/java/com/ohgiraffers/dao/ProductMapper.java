package com.ohgiraffers.dao;

import com.ohgiraffers.dto.ProductDTO;

import java.util.List;

public interface ProductMapper {

    List<ProductDTO> selectAllProduct();

    int deleteProduct(int code);

    int updateProduct(ProductDTO product);

}
