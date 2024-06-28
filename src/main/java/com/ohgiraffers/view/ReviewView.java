package com.ohgiraffers.view;

import com.ohgiraffers.controller.ReviewController;

import java.util.HashMap;
import java.util.Map;
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

            switch (no) {
                case 1:
                    reviewController.insertReview(inputReview());
                    break;
                case 2:
                    reviewController.updateReview(inputUpdateReview());
                    break;
                case 3:
                    reviewController.deleteReview(inputReviewId());
                    break;
                case 4:
                    reviewController.selectMyReviews(inputReviewId());
                    break;
                case 5:
                    reviewController.selectReviewByProductCode(inputProductCode());
                    break;
                case 0:
                    return;
            }
        } while (true);
    }

    private static Map<String, String> inputReview() {
        Scanner sc = new Scanner(System.in);

        System.out.print("추가할 별점을 입력하세요 : ");
        String ratings = sc.nextLine();
        System.out.print("추가할 구매자 아이디를 입력해주세요 : ");
        String orderId = sc.nextLine();
        System.out.print("추가할 세부사항을 입력해주세요 : ");
        String reviewDetail = sc.nextLine();
        System.out.print("추가할 상품 코드를 입력해주세요 : ");
        String productCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("ratings", ratings);
        parameter.put("reviewDetail", reviewDetail);
        parameter.put("productCode", productCode);
        parameter.put("orderId", orderId);
        return parameter;

    }

    private static Map<String, String> inputUpdateReview() {


        Scanner sc = new Scanner(System.in);

        System.out.print("어떤 리뷰를 수정할지 번호를 입력하세요 : ");
        int reviewId = sc.nextInt();

        System.out.print("수정할 리뷰별점을 입력하세요 : ");
        double ratings = sc.nextDouble();

        System.out.print("수정할 리뷰 내용을 입력하세요 : ");
        String reviewDetail = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();

        parameter.put("reviewId", String.valueOf(reviewId));
        parameter.put("ratings", String.valueOf(ratings));
        parameter.put("reviewDetail", reviewDetail);

        return parameter;
    }

    private static Map<String, String> inputReviewId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("주문자 아이디를 입력하세요 : ");
        String orderId = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("orderId",orderId);

        return parameter;

    }


    private static Map<String, String> inputProductCode() {

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 리뷰의 상품 번호를 입력하세요 : ");
        String productCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("productCode", productCode);

        return parameter;
    }

}
