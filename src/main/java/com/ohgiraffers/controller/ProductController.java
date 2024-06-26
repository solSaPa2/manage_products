package com.ohgiraffers.controller;
import com.ohgiraffers.service.ProductService;

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
}
