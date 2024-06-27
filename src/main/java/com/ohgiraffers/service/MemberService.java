package com.ohgiraffers.service;

import com.ohgiraffers.dao.MemberMapper;
import com.ohgiraffers.dto.AdministratorDTO;
import com.ohgiraffers.dto.MemberDTO;
import com.ohgiraffers.dto.SellerDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MemberService {
    private MemberMapper mapper;

    public MemberDTO selectLoginInfo(Map<String, String> map) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        MemberDTO member = mapper.selectLoginInfo(map);

        sqlSession.close();

        return member;
    }

    public int insertMember(Map<String, String> map) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        int result = mapper.insertMember(map);

        if (result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public MemberDTO selectExistingId(String memberId) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        MemberDTO member = mapper.selectExistingId(memberId);

        sqlSession.close();

        return member;
    }

    public MemberDTO selectMember(String memberId) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        MemberDTO member = mapper.selectExistingId(memberId);

        sqlSession.close();

        return member;
    }

    public int updateMember(Map<String, String> memberInfo) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        int result = mapper.updateMember(memberInfo);

        if (result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public int deleteMember(String memberId) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        int result = mapper.deleteMember(memberId);

        if (result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public int insertSeller(String memberId) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        int result = mapper.insertSeller(memberId);

        if (result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public int insertAdministrator(Map<String, String> map) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        int result = mapper.insertAdministrator(map);

        if (result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public boolean selectSeller(String memberId) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        SellerDTO seller = mapper.selectSeller(memberId);

        sqlSession.close();

        if (seller != null){
            return true;
        } else {
            return false;
        }
    }

    public boolean selectAdministrator(String memberId) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(MemberMapper.class);

        AdministratorDTO administrator = mapper.selectAdministrator(memberId);

        sqlSession.close();

        if (administrator != null){
            return true;
        } else {
            return false;
        }
    }
}
