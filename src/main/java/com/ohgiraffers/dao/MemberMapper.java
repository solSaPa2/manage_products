package com.ohgiraffers.dao;

import com.ohgiraffers.dto.MemberDTO;

import java.util.Map;

public interface MemberMapper {
    MemberDTO selectLoginInfo(Map<String, String> map);
}
