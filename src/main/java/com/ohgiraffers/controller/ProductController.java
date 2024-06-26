package com.ohgiraffers.controller;

import com.ohgiraffers.dto.CategoryDTO;
import com.ohgiraffers.dto.ProductDTO;
import com.ohgiraffers.service.ProductService;

import java.util.List;

public class ProductController {

    private final ProductService productService;

    public ProductController(){
        productService = new ProductService();
    }

    public void selectAllProducts(){

        List<ProductDTO> productList = productService.selectAllProducts();

        if(productList != null){
            for(ProductDTO product : productList) {
                System.out.println(product);
            }
        }else{
            System.out.println("결과 출력 실패!!!");
        }
    }


}
