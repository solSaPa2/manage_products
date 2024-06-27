package com.ohgiraffers.view;

import com.ohgiraffers.controller.ProductController;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

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
                case 1: productController.insertProduct(inputMenu()); break;
                case 2: productController.updateProduct(inputModifyMenu()); break;
                case 3: productController.deleteProduct(inputMenuCode()); break;
                case 4: productController.selectAllProducts(); break;
//               case 5: productController.selectProductByCode(); break;
                case 0: return;
            }
        } while (true);
    }

    private  static Map<String, String > inputMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("추가할 상품 코드를 입력하세요 : ");
        String productCode = sc.nextLine();
        System.out.print("추가할 상품 이름을 입력하세요 : ");
        String productName = sc.nextLine();
        System.out.print("추가할 상품 카테고리를 입력해주세요 : ");
        String categoryCode = sc.nextLine();
        System.out.print("추가할 상품 수량을 입력해주세요 : ");
        String productQuantity = sc.nextLine();
        System.out.print("추가할 상품 세부사항을 입력해주세요 : ");
        String productDetail = sc.nextLine();


        Map<String, String> parameter = new HashMap<>();
        parameter.put("productCode",productCode);
        parameter.put("productName",productName);
        parameter.put("categoryCode",categoryCode);
        parameter.put("productQuantity",productQuantity);
        parameter.put("productDetail", productDetail);
        return parameter;

    }

    private  static Map<String, String > inputMenuCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("상품 코드를 입력하세요 :");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code",code);

        return parameter;

    }

    private static Map<String, String> inputModifyMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.print("수정할 상품 코드를 입력하세요 :");
        String productCode = sc.nextLine();
        System.out.print("수정할 상품 이름을 입력하세요 : ");
        String productName = sc.nextLine();
        System.out.print("수정할 카테고리 코드를 입력하세요 : ");
        String categoryCode = sc.nextLine();
        System.out.print("수정할 상품 수량을 입력하세요 : ");
        String productQuantity = sc.nextLine();
        System.out.print("수정할 상품 세부사항을 작성하세요 : ");
        String productDetail = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("productCode",productCode);
        parameter.put("productName",productName);
        parameter.put("categoryCode",categoryCode);
        parameter.put("productQuantity",productQuantity);
        parameter.put("productDetail", productDetail);
        return parameter;

    }

}
