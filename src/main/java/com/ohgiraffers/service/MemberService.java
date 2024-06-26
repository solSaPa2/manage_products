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
}
