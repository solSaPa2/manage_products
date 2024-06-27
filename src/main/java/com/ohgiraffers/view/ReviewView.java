package com.ohgiraffers.view;

import com.ohgiraffers.controller.ReviewController;

import java.util.Scanner;

public class ReviewView {

    public void reviewSubMenu() {
        Scanner sc = new Scanner(System.in);
        ReviewController reviewController = new ReviewController();

        do {
            System.out.println("\n========== 리뷰 관리 메뉴 ==========");
            System.out.println("1. 리뷰 등록\n2. 리뷰 수정\n3. 리뷰 삭제\n4. 나의 리뷰 리스트 조회\n5. 상품의 전체 리뷰 조회\n0. 이전 메뉴로");
            System.out.println("--------------------------------------------");
            System.out.print("번호 입력: ");
            int no = sc.nextInt();
            sc.nextLine();

            switch (no){
//                case 1: reviewController.insertReview(); break;
//                case 2: reviewController.updateReview(); break;
//                case 3: reviewController.deleteReview(); break;
//                case 4: reviewController.selectMyReviews(); break;
//                case 5: reviewController.selectAllReviewsByProductCode(); break;
                case 0: return;
            }
        } while (true);
    }
}
