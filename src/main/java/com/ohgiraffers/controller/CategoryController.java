package com.ohgiraffers.controller;

import com.ohgiraffers.dto.CategoryDTO;
import com.ohgiraffers.dto.CategoryProductDTO;
import com.ohgiraffers.dto.ProductDTO;
import com.ohgiraffers.service.CategoryService;

import java.util.List;
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

        if (categoryService.insertCategory(category)) {
            System.out.println("신규 카테고리 등록을 성공했습니다!");
        } else {
            System.out.println("신규 카테고리 등록을 실패했습니다!");
        }
    }

    public void selectAllCategory() {

        List<CategoryDTO> categoryList = categoryService.selectAllCategory();

        if (categoryList != null) {
            for (CategoryDTO category : categoryList) {
                System.out.println(category);
            }
        } else {
            System.out.println("카테고리 목록 조회를 실패했습니다!");
        }
    }


    public void updateCategory(Map<String, String> parameter) {

        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
        String categoryName = parameter.get("categoryName");

        CategoryDTO category = new CategoryDTO();

        category.setCategoryCode(categoryCode);
        category.setCategoryName(categoryName);


        if (categoryService.updateCategory(category)) {
            System.out.println("카테고리 수정을 성공했습니다!");
        } else {
            System.out.println("카테고리 수정을 실패했습니다!");
        }
    }

    public void deleteCategory(Map<String, String> parameter) {

        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        if (categoryService.deleteCategory(categoryCode)) {
            System.out.println("카테고리 삭제을 성공했습니다!");
        } else {
            System.out.println("카테고리 삭제를 실패했습니다!");
        }
    }

    public void selectProductByCategoryCode(Map<String, String> parameter) {

        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        CategoryDTO category = new CategoryDTO();

        category.setCategoryCode(categoryCode);

        CategoryProductDTO categoryProduct = categoryService.selectProductByCategoryCode(categoryCode);

        if (categoryProduct != null) {

            for (ProductDTO pro : categoryProduct.getProList()) {

                System.out.println(pro.getProductName());
            }

        } else {
            System.out.println(" ");
        }
    }

}
