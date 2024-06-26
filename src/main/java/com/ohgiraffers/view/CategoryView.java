package com.ohgiraffers.view;

import com.ohgiraffers.controller.CategoryController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CategoryView {
    public void categorySubMenu() {
        Scanner sc = new Scanner(System.in);
        CategoryController categoryController = new CategoryController();

        do {
            System.out.println("\n========== 카테고리 관리 메뉴 ==========");
            System.out.println("1. 카테고리 등록\n2. 카테고리 수정\n3. 카테고리 삭제\n4. 카테고리 리스트 조회\n5. 해당 카테고리 상품 검색\n0. 이전 메뉴로");
            System.out.println("--------------------------------------------");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1: categoryController.insertCategory(inputInsertCategory()); break;
                case 2: categoryController.updateCategory(inputUpdateCategory()); break;
//                case 3: categoryController.deleteCategory(); break;
                case 4: categoryController.selectAllCategory(); break;
//                case 5: categoryController.selectProductByCategoryCode(); break;
                case 0: return;
            }
        } while (true);
    }

    private static Map<String, String> inputInsertCategory() {

        Scanner sc = new Scanner(System.in);

        System.out.print("카테고리 이름을 입력하세요 : ");
        String categoryName = sc.nextLine();


        Map<String, String> parameter = new HashMap<>();

        parameter.put("categoryName",categoryName);

        return parameter;
    }

    private static Map<String, String> inputUpdateCategory() {

        Scanner sc = new Scanner(System.in);

        System.out.print("수정할 카테고리 코드을 입력하세요 : ");
        String categoryCode = sc.nextLine();
        System.out.print("수정할 카테고리 이름을 입력하세요 : ");
        String categoryName = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();

        parameter.put("categoryCode",categoryCode);
        parameter.put("categoryName",categoryName);

        return parameter;
    }


}
