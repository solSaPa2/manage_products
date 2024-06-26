package com.ohgiraffers.dao;

import com.ohgiraffers.dto.CategoryDTO;

import java.util.List;

public interface CategoryMapper {

    int insertCategory(CategoryDTO category);

    List<CategoryDTO> selectAllCategory();
}
