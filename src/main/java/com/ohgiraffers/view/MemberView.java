package com.ohgiraffers.view;

import com.ohgiraffers.controller.MemberController;

import java.util.Scanner;

public class MemberView {
    public void memberSubMenu() {
        Scanner sc = new Scanner(System.in);
        MemberController memberController = new MemberController();

        do {
            System.out.println("\n========== 회원 메뉴 ==========");
            System.out.println("1. 로그인\n2. 로그아웃\n3. 회원 가입\n4. 회원 탈퇴\n5. 회원 정보 수정\n6. 회원 정보 조회\n0. 이전 메뉴로");
            System.out.println("--------------------------------------------");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
//                case 1: memberController.selectLoginInfo(); break;
//                case 2: logout(); break;
//                case 3: memberController.insertMember(); break;
//                case 4: memberController.deleteMember(); break;
//                case 5: memberController.updateMember(); break;
//                case 6: memberController.selectMember(); break;
                case 0: return;
            }
        } while (true);
    }


}
