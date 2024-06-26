package com.ohgiraffers.controller;

import com.ohgiraffers.dto.MemberDTO;
import com.ohgiraffers.service.MemberService;

import java.util.Map;

public class MemberController {
    private final MemberService memberService;

    public MemberController() {
        memberService = new MemberService();
    }

    public boolean selectLoginInfo(Map<String, String> map) {
//        String memberId = map.get("memberId");
//        String memberPassword = map.get("memberPassword");
        MemberDTO member = memberService.selectLoginInfo(map);

        if (member != null){
            System.out.println("로그인 성공!");
            return true;
        } else {
            System.out.println("로그인 실패!");
            return false;
        }
    }
}
