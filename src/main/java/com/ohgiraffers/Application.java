package com.ohgiraffers;

import com.ohgiraffers.view.CategoryView;
import com.ohgiraffers.view.MemberView;
import com.ohgiraffers.view.ProductView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        MemberView memberView = new MemberView();
        ProductView productView = new ProductView();
        CategoryView categoryView = new CategoryView();

        do{
            System.out.println("\n===== 상품 관리 시스템 =====");
            System.out.println("1. 로그인 / 회원등록 / 회원 탈퇴\n" +
                    "2. 상품 관리\n" +
                    "3. 카테고리 관리\n" +
                    "0. 프로그램 종료\n" +
                    "-----------------------------");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();

            switch (no){
                case 1: memberView.memberSubMenu(); break;
                case 2: productView.productSubMenu(); break;
                case 3: categoryView.categorySubMenu(); break;
                case 0: flag = false; break;
                default: System.out.println("잘못된 메뉴를 선택하셨습니다."); break;
            }
        } while(flag);
    }
}
