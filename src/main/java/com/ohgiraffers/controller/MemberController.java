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
        MemberDTO member = memberService.selectLoginInfo(map);

        if (member != null){
            System.out.println("로그인 성공!");
            return true;
        } else {
            System.out.println("로그인 실패!");
            return false;
        }
    }

    public void insertMember(Map<String, String> map) {
        String memberId = map.get("memberId");
        MemberDTO member = memberService.selectExistingId(memberId);

        if (member == null){
            int result = memberService.insertMember(map);

            if (result > 0){
                System.out.println("회원 등록 성공!");
            } else {
                System.out.println("회원 등록 실패!");
            }
        } else{
            System.out.println("이미 존재하는 id입니다.");
        }
    }
}
