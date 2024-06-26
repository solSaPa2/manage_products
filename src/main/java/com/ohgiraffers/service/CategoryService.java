package com.ohgiraffers.service;

import com.ohgiraffers.dao.CategoryMapper;
import com.ohgiraffers.dto.CategoryDTO;
import com.ohgiraffers.dto.CategoryProductDTO;
import com.ohgiraffers.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;


import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class CategoryService {

    private CategoryMapper categoryMapper;

    public boolean insertCategory(CategoryDTO category){

        SqlSession sqlSession = getSqlSession();

        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        int result = categoryMapper.insertCategory(category);

        if(result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public List<CategoryDTO> selectAllCategory() {

        SqlSession sqlSession = getSqlSession();

        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        List<CategoryDTO> categoryList = categoryMapper.selectAllCategory();

        sqlSession.close();

        return categoryList;
    }

    public boolean updateCategory(CategoryDTO category) {

        SqlSession sqlSession = getSqlSession();

        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        int result = categoryMapper.updateCategory(category);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean deleteCategory(int categoryCode) {

        SqlSession sqlSession = getSqlSession();

        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        int result = categoryMapper.deleteCategory(categoryCode);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public CategoryProductDTO selectProductByCategoryCode(int categoryCode) {

        SqlSession sqlSession = getSqlSession();

        categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        CategoryProductDTO categoryProduct = categoryMapper.selectProductByCategoryCode(categoryCode);

        sqlSession.close();

        return categoryProduct;
    }
}
