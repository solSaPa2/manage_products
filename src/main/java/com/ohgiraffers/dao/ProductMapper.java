package com.ohgiraffers.dao;

import com.ohgiraffers.dto.ProductDTO;

import java.util.List;

public interface ProductMapper {

    int insertProduct(ProductDTO product);

    int deleteProduct(int code);

    int updateProduct(ProductDTO product);

    List<ProductDTO> selectAllProduct();

    ProductDTO selectProductByCode(int code);
}
