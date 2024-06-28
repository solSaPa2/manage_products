package com.ohgiraffers.view;

import com.ohgiraffers.controller.OrderController;
import com.ohgiraffers.controller.ReviewController;
import com.ohgiraffers.dto.OrderDetailDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReviewView {

    public void reviewSubMenu(Map<String, String> loginInfo) {
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
                    reviewController.insertReview(inputReview(loginInfo));
                    break;
                case 2:
                    reviewController.updateReview(inputUpdateReview(loginInfo));
                    break;
                case 3:
                    reviewController.deleteReview(inputDeleteReview(loginInfo));
                    break;
                case 4:
                    reviewController.selectMyReviews(loginInfo);
                    break;
                case 5:
                    reviewController.selectReviewByProductCode(inputProductCode());
                    break;
                case 0:
                    return;
            }
        } while (true);
    }

    private Map<String, String> inputDeleteReview(Map<String, String> loginInfo) {
        ReviewController reviewController = new ReviewController();
        reviewController.selectMyReviews(loginInfo);

        Scanner sc = new Scanner(System.in);
        System.out.print("위의 리뷰 중 삭제할 리뷰 번호를 입력하세요: ");
        String reviewId = sc.nextLine();

        Map<String, String> map = new HashMap<>();
        map.put("reviewId", reviewId);

        return map;
    }

    private static Map<String, String> inputReview(Map<String, String> loginInfo) {
        OrderController orderController = new OrderController();
        orderController.selectOrderHistory(loginInfo);

        Scanner sc = new Scanner(System.in);

        System.out.print("주문 번호를 입력해주세요: ");
        String orderId = sc.nextLine();

        String productCode = "";

        List<OrderDetailDTO> orderDetailList = orderController.selectOrderDetail(orderId);    // 주문했던 상품 개수
        if (orderDetailList.size() == 1){
            productCode = "" + orderDetailList.get(0).getProductCode();
        } else {
            System.out.print("상품 코드를 입력해주세요: ");
            productCode = sc.nextLine();
        }

        System.out.print("별점을 입력해주세요 (1.0 ~ 5.0): ");
        String ratings = sc.nextLine();
        System.out.print("리뷰내용을 입력해주세요 : ");
        String reviewDetail = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("orderId", orderId);
        parameter.put("ratings", ratings);
        parameter.put("reviewDetail", reviewDetail);
        parameter.put("productCode", productCode);

        return parameter;
    }

    private static Map<String, String> inputUpdateReview(Map<String, String> loginInfo) {
        ReviewController reviewController = new ReviewController();
        reviewController.selectMyReviews(loginInfo);

        Scanner sc = new Scanner(System.in);
        System.out.print("위의 리뷰 중 수정할 리뷰 번호를 입력하세요: ");
        int reviewId = sc.nextInt();

        System.out.print("수정할 리뷰별점을 입력하세요 : ");
        double ratings = sc.nextDouble();
        sc.nextLine();

        System.out.print("수정할 리뷰 내용을 입력하세요 : ");
        String reviewDetail = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();

        parameter.put("reviewId", String.valueOf(reviewId));
        parameter.put("ratings", String.valueOf(ratings));
        parameter.put("reviewDetail", reviewDetail);

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