package com.ohgiraffers.view;

import com.ohgiraffers.controller.MemberController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemberView {
    public Map<String, String> memberSubMenu(Map<String, String> loginInfo) {
        Scanner sc = new Scanner(System.in);
        MemberController memberController = new MemberController();

        boolean flag = true;

        do {
            System.out.println("\n=============== 회원 메뉴 ===============");
            if (loginInfo.get("login").equals("true")){
                System.out.println("1. 로그아웃\n2. 회원 정보 수정\n3. 회원 정보 조회\n4. 회원 탈퇴\n0. 이전 메뉴로");
                System.out.println("----------------------------------------");
                System.out.print("번호 입력: ");
                int no = sc.nextInt();
                sc.nextLine();

                switch (no){
                    case 1: loginInfo = logout(loginInfo); break;
                    case 2: loginInfo = memberController.updateMember(updateMemberInfo(loginInfo)); break;
                    case 3: memberController.selectMember(loginInfo); break;
                    case 4: loginInfo = memberController.deleteMember(loginInfo); break;
                    case 0: flag = false; break;
                }
            } else {
                System.out.println("1. 로그인\n2. 회원 가입\n0. 이전 메뉴로");
                System.out.println("----------------------------------------");
                System.out.print("번호 입력: ");
                int no = sc.nextInt();
                sc.nextLine();

                switch (no){
                    case 1: loginInfo = memberController.selectLoginInfo(inputLoginInfo()); break;
                    case 2: memberController.insertMember(inputNewMember()); break;
                    case 0: flag = false; break;
                }
            }

        } while (flag);

        return loginInfo;
    }

    private Map<String,String> logout(Map<String,String> loginInfo) {
       if (loginInfo.get("login").equals("true")){
            loginInfo.put("login","false");
            loginInfo.put("memberId","");
            System.out.println("로그아웃 되었습니다.");
        }
        return loginInfo;
    }

    public Map<String, String> inputLoginInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("id 입력: ");
        String memberId = sc.nextLine();
        System.out.print("비밀번호 입력: ");
        String memberPassword = sc.nextLine();

        Map<String,String> map = new HashMap<>();
        map.put("memberId",memberId);
        map.put("memberPassword",memberPassword);

        return map;
    }

    public Map<String, String> inputNewMember(){
        Scanner sc = new Scanner(System.in);
        System.out.print("id: ");
        String memberId = sc.nextLine();
        System.out.print("비밀번호: ");
        String memberPassword = sc.nextLine();
        System.out.print("이름: ");
        String memberName = sc.nextLine();
        System.out.print("전화번호: ");
        String memberPhoneNumber = sc.nextLine();
        System.out.print("주민등록번호: ");
        String memberIdentityNumber = sc.nextLine();
        System.out.print("이메일 주소: ");
        String memberEmail = sc.nextLine();

        System.out.print("회원 분류 (1. 일반 회원, 2. 판매자, 3. 관리자): ");
        String memberType = sc.nextLine();

        Map<String,String> map = new HashMap<>();

        if(memberType.equals("3") || (!memberType.contains("일반") && memberType.contains("관리자") && !memberType.contains("판매"))){
            System.out.print("관리자 비밀번호 입력: ");
            String adminPassword = sc.nextLine();
            map.put("adminPassword",adminPassword);
        }

        map.put("memberId",memberId);
        map.put("memberPassword",memberPassword);
        map.put("memberName",memberName);
        map.put("memberPhoneNumber",memberPhoneNumber);
        map.put("memberIdentityNumber",memberIdentityNumber);
        map.put("memberEmail",memberEmail);
        map.put("memberType",memberType);

        return map;
    }

    public Map<String, String> updateMemberInfo(Map<String,String> loginInfo){
        Scanner sc = new Scanner(System.in);
        System.out.print("id: ");
        String memberId = sc.nextLine();
        System.out.print("비밀번호: ");
        String memberPassword = sc.nextLine();
        System.out.print("이름: ");
        String memberName = sc.nextLine();
        System.out.print("전화번호: ");
        String memberPhoneNumber = sc.nextLine();
        System.out.print("주민등록번호: ");
        String memberIdentityNumber = sc.nextLine();
        System.out.print("이메일 주소: ");
        String memberEmail = sc.nextLine();

        Map<String,String> map = new HashMap<>();
        map.put("previousId",loginInfo.get("memberId"));

        map.put("memberId",memberId);
        map.put("memberPassword",memberPassword);
        map.put("memberName",memberName);
        map.put("memberPhoneNumber",memberPhoneNumber);
        map.put("memberIdentityNumber",memberIdentityNumber);
        map.put("memberEmail",memberEmail);

        return map;
    }
}
