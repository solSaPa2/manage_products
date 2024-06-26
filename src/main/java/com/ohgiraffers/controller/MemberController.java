package com.ohgiraffers.controller;

import com.ohgiraffers.dto.MemberDTO;
import com.ohgiraffers.service.MemberService;

import java.util.HashMap;
import java.util.Map;

public class MemberController {
    private final MemberService memberService;

    public MemberController() {
        memberService = new MemberService();
    }

    public Map<String, String> selectLoginInfo(Map<String, String> map) {
        MemberDTO member = memberService.selectLoginInfo(map);

        Map<String, String> loginInfo = new HashMap<>();

        if (member != null){
            System.out.println("로그인 성공!");
            loginInfo.put("login","true");
            loginInfo.put("memberId",map.get("memberId"));
            return loginInfo;
        } else {
            System.out.println("로그인 실패!");
            loginInfo.put("login","false");
            loginInfo.put("memberId","");
            return loginInfo;
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

    public void selectMember(Map<String, String> loginInfo) {
        if (loginInfo.get("login").equals("true")){
            String memberId = loginInfo.get("memberId");
            MemberDTO member = memberService.selectMember(memberId);

            System.out.println("id: " + member.getMemberId());
            System.out.println("이름: " + member.getMemberName());
            System.out.println("전화번호: " + member.getMemberPhoneNumber());
            System.out.println("주민등록번호: " + member.getMemberIdentityNumber());
            System.out.println("가입 날짜: " + member.getMemberRegisteredDate());
            System.out.println("이메일 주소: " + member.getMemberEmail());
        } else{
            System.out.println("로그인 되어있지 않습니다. 로그인 후 다시 시도해주세요.");
        }
    }

    public Map<String, String> updateMember(Map<String, String> memberInfo) {
        String previousId = memberInfo.get("previousId");
        String memberId = memberInfo.get("memberId");

        MemberDTO member = null;
        if (!previousId.equals(memberId)){
            member = memberService.selectExistingId(memberId);
        }

        Map<String, String> loginInfo = new HashMap<>();
        loginInfo.put("login","true");
        loginInfo.put("memberId",previousId);

        if (member == null){
            int result = memberService.updateMember(memberInfo);

            if (result > 0){
                System.out.println("회원 정보 수정 성공!");
                loginInfo.put("memberId",memberId);
            } else {
                System.out.println("회원 정보 수정 실패!");
            }
        } else{
            System.out.println("이미 존재하는 id입니다.");
        }

        return loginInfo;
    }

    public Map<String, String> deleteMember(Map<String, String> loginInfo) {
        int result = memberService.deleteMember(loginInfo.get("memberId"));

        if (result > 0){
            System.out.println("회원 탈퇴 성공!");
            loginInfo.put("login","false");
            loginInfo.put("memberId","");
        } else {
            System.out.println("회원 탈퇴 실패!");
        }

        return loginInfo;
    }
}
