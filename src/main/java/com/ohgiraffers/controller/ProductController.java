package com.ohgiraffers.controller;

import com.ohgiraffers.dto.ProductDTO;
import com.ohgiraffers.service.ProductService;

import java.util.List;
import java.util.Map;

public class ProductController {

    private final ProductService productService;

    public ProductController(){
        productService = new ProductService();
    }

    public void insertProduct(Map<String, String> parameter) {

        int code =
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if(menuService.registMenu(menu)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }


    public void deleteProduct(Map<String,String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));

        if(productService.deleteProduct(code)){
            System.out.println("삭제 성공");
        }else{
            System.out.println("삭제 실패");
        }
    }

    public void updateProduct(Map<String, String> parameter) {

        int productCode = Integer.parseInt(parameter.get("productCode"));
        String productName = parameter.get("productName");
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
        int productQuantity = Integer.parseInt(parameter.get("productQuantity"));
        String productDetail = parameter.get("productDetail");

        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductCode(productCode);
        productDTO.setProductName(productName);
        productDTO.setCategoryCode(categoryCode);
        productDTO.setProductQuantity(productQuantity);
        productDTO.setProductDetail(productDetail);

        if(productService.updateProduct(productDTO)){
            System.out.println("변경 성공");
        }else{
            System.out.println("변경 실패");
        }

    }
}
