package com.ohgiraffers.dao;

import com.ohgiraffers.dto.MemberDTO;

import java.util.Map;

public interface MemberMapper {
    MemberDTO selectLoginInfo(Map<String, String> map);

    int insertMember(Map<String, String> map);

    MemberDTO selectExistingId(String memberId);

    int updateMember(Map<String, String> memberInfo);

    int deleteMember(String memberId);
}
