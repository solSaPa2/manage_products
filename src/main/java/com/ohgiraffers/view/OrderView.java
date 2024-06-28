package com.ohgiraffers.view;

import com.ohgiraffers.controller.OrderController;
import com.ohgiraffers.controller.ProductController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrderView {
    public void orderSubMenu(Map<String, String> loginInfo) {
        Scanner sc = new Scanner(System.in);
        OrderController orderController = new OrderController();

        boolean flag = true;

        do {
            System.out.println("1. 상품 구매하기");
            System.out.println("2. 상품 구매 히스토리 조회");
            System.out.println("----------------------------------------");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
                case 1: orderController.insertOrder(inputOrder(loginInfo)); break;
//                case 2: orderController.selectOrderHistory(); break;
                case 0: flag = false; break;
            }
        } while (flag);
    }

    private Map<String,String> inputOrder(Map<String,String> loginInfo) {
        // 상품 리스트 보여주기
        ProductController productController = new ProductController();
        productController.selectAllProducts();

        Scanner sc = new Scanner(System.in);
        Map<String,String> map = new HashMap<>();
        map.put("memberId",loginInfo.get("memberId"));

        boolean flag = true;
        int i = 0;
        while (flag){
            System.out.println("----------------------------------------");
            System.out.println("어떤 상품을 구매하시겠습니까?");
            System.out.print("상품 번호를 입력(그만하려면 exit): ");
            String productCode = sc.nextLine();

            if (!productCode.equals("exit")){
                System.out.print("수량 입력: ");
                int quantity = sc.nextInt();
                sc.nextLine();

                map.put("productCode".concat(Integer.toString(i)), productCode);
                map.put("quantity".concat(Integer.toString(i)), Integer.toString(quantity));
                i++;
            } else {
                flag = false;
            }
        }

        return map;
    }
}
