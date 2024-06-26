package com.ohgiraffers.service;

import com.ohgiraffers.dao.MemberMapper;
import com.ohgiraffers.dto.MemberDTO;
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
}
