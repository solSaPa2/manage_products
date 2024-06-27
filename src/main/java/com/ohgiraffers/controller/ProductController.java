package com.ohgiraffers.controller;

import com.ohgiraffers.dto.ProductDTO;
import com.ohgiraffers.service.ProductService;


import java.util.Map;

public class ProductController {

    private final ProductService productService;

    public ProductController(){
        productService = new ProductService();
    }

    public void insertProduct(Map<String, String> parameter) {

        int productCode = Integer.parseInt(parameter.get("productCode"));
        String productName = parameter.get("productName");
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
        int productQuantity = Integer.parseInt(parameter.get("productQuantity"));
        String productDetail = parameter.get("productDetail");

        ProductDTO product = new ProductDTO();

        product.setProductCode(productCode);
        product.setProductName(productName);
        product.setCategoryCode(categoryCode);
        product.setProductQuantity(productQuantity);
        product.setProductDetail(productDetail);

        if(productService.insertProduct(product)) {
            System.out.println("추가 성공");
        } else {
            System.out.println("추가 실패");
        }
    }

}
