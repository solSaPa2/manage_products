package com.ohgiraffers.service;

import com.ohgiraffers.dao.CategoryMapper;
import com.ohgiraffers.dto.CategoryDTO;
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
}
