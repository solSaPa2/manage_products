package com.ohgiraffers.controller;

import com.ohgiraffers.dto.ProductDTO;
import com.ohgiraffers.service.ProductService;

import java.util.List;

public class ProductController {

    private final ProductService productService;
    private final PrintResult printResult;

    public ProductController(){
        productService = new ProductService();
        printResult = new PrintResult();
    }


    public void selectAllProducts(){

        List<ProductDTO> productList = productService.selectAllProducts();

        if(productList != null){
            printResult.printProductList(productList);
        }else{
            printResult.printErrorMessage("selectList");
        }
    }




}
