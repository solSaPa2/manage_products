package com.ohgiraffers;

import com.ohgiraffers.view.CategoryView;
import com.ohgiraffers.view.MemberView;
import com.ohgiraffers.view.ProductView;
import com.ohgiraffers.view.ReviewView;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        Map<String, String> loginInfo = new HashMap<>();
        loginInfo.put("login","false");
        loginInfo.put("memberId","");

        MemberView memberView = new MemberView();
        ProductView productView = new ProductView();
        CategoryView categoryView = new CategoryView();

        do{
            System.out.println("\n================ 상품 관리 시스템 ================");
            if (loginInfo.get("login").equals("false")){
                System.out.println("1. 로그인 / 회원등록");
            } else if(loginInfo.get("login").equals("true")){
                System.out.println("1. 로그아웃 / 회원탈퇴 / 회원정보 수정 / 내 정보 조회");
            }
            System.out.println("2. 상품 관리\n" +
                    "3. 카테고리 관리\n" +
                    "0. 프로그램 종료\n" +
                    "------------------------------------------------");
            System.out.print("번호 입력 : ");
            int no = sc.nextInt();

            switch (no){
                case 1: loginInfo = memberView.memberSubMenu(loginInfo); break;
                case 2: productView.productSubMenu(); break;
                case 3: categoryView.categorySubMenu(); break;
                case 0: flag = false; break;
                default: System.out.println("잘못된 메뉴를 선택하셨습니다."); break;
            }
        } while(flag);
    }
}
