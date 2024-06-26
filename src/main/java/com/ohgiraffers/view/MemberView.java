package com.ohgiraffers.view;

import com.ohgiraffers.controller.MemberController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemberView {
    public boolean memberSubMenu(boolean loggedIn) {
        Scanner sc = new Scanner(System.in);
        MemberController memberController = new MemberController();

        boolean flag = true;

        do {
            System.out.println("\n========== 회원 메뉴 ==========");
            if (loggedIn){
                System.out.println("1. 로그아웃\n2. 회원 정보 수정\n3. 회원 정보 조회\n4. 회원 탈퇴\n0. 이전 메뉴로");
                System.out.println("--------------------------------------------");
                System.out.print("번호 입력: ");
                int no = sc.nextInt();
                sc.nextLine();

                switch (no){
                    case 1: loggedIn = logout(loggedIn); break;
//                    case 2: memberController.updateMember(); break;
//                    case 3: memberController.selectMember(); break;
//                    case 4: memberController.deleteMember(); break;
                    case 0: flag = false; break;
                }
            } else {
                System.out.println("1. 로그인\n2. 회원 가입\n0. 이전 메뉴로");
                System.out.println("--------------------------------------------");
                System.out.print("번호 입력: ");
                int no = sc.nextInt();
                sc.nextLine();

                switch (no){
                    case 1: loggedIn = memberController.selectLoginInfo(inputLoginInfo()); break;
//                case 3: memberController.insertMember(); break;
//                case 4: memberController.deleteMember(); break;
//                case 5: memberController.updateMember(); break;
//                case 6: memberController.selectMember(); break;
                    case 0: flag = false; break;
                }
            }

        } while (flag);

        return loggedIn;
    }

    private boolean logout(boolean loggedIn) {
        if (loggedIn){
            loggedIn = false;
            System.out.println("로그아웃 되었습니다.");
        }
        return loggedIn;
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


}
