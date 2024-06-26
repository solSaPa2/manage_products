package com.ohgiraffers.dao;

import com.ohgiraffers.dto.CategoryDTO;
import com.ohgiraffers.dto.CategoryProductDTO;

import java.util.List;

public interface CategoryMapper {

    int insertCategory(CategoryDTO category);

    List<CategoryDTO> selectAllCategory();

    int updateCategory(CategoryDTO category);

    int deleteCategory(int categoryCode);

    CategoryProductDTO selectProductByCategoryCode(int categoryCode);
}
