package com.ohgiraffers.view;

import com.ohgiraffers.controller.ProductController;

import java.util.Scanner;

public class ProductView {
    public void productSubMenu() {
        Scanner sc = new Scanner(System.in);
        ProductController productController = new ProductController();

        do {
            System.out.println("\n========== 상품 관리 메뉴 ==========");
            System.out.println("1. 상품 등록\n2. 상품 정보 수정\n3. 상품 삭제\n4. 상품 정보 리스트 조회\n5. 상품 검색\n0. 이전 메뉴로");
            System.out.println("--------------------------------------------");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1: productController.insertProduct(); break;
//                case 2: productController.updateProduct(); break;
//                case 3: productController.deleteProduct(); break;
//                case 4: productController.selectAllProducts(); break;
//                case 5: productController.selectProductByCode(); break;
                case 0: return;
            }
        } while (true);
    }


}
