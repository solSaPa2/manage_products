package com.ohgiraffers.controller;

import com.ohgiraffers.dto.CategoryDTO;
import com.ohgiraffers.service.CategoryService;

import java.util.Map;

public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController() {
        categoryService = new CategoryService();
    }

    public void insertCategory(Map<String, String> parameter) {

        String categoryName = parameter.get("categoryName");

        CategoryDTO category = new CategoryDTO();

        category.setCategoryName(categoryName);

        if(categoryService.insertCategory(category)) {
            System.out.println("신규 카테고리 등록을 성공했습니다!");
        }else {
            System.out.println("신규 카테고리 등록을 실패했습니다!");
        }
    }
}
