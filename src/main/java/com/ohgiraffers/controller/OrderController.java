package com.ohgiraffers.controller;

import com.ohgiraffers.dto.OrderDetailDTO;
import com.ohgiraffers.dto.OrdersOrderDetailDTO;
import com.ohgiraffers.dto.ProductDTO;
import com.ohgiraffers.service.OrderService;
import com.ohgiraffers.service.ProductService;

import java.util.List;
import java.util.Map;

public class OrderController {
    private final OrderService orderService;

    public OrderController() {
        orderService = new OrderService();
    }

    public void insertOrder(Map<String, String> map) {
        int result = orderService.insertOrder(map);

        if (map.size()-1 > 0){
            if (result > 0){
                System.out.println("주문 성공!");
            } else {
                System.out.println("주문 실패!");
            }
        } else{
            System.out.println("주문할 상품을 입력하지 않으셨습니다.");
        }
    }

    public void selectOrderHistory(Map<String, String> loginInfo) {
        List<OrdersOrderDetailDTO> ordersList = orderService.selectOrderHistory(loginInfo);

        if (ordersList.size() == 0){
            System.out.println("주문 내역이 없습니다.");
        } else{
            for (OrdersOrderDetailDTO orders : ordersList){
                System.out.println("===============================================");
                System.out.println("주문 번호: " + orders.getOrderId());
                System.out.println("주문 시간: " + orders.getOrderTime());
                System.out.println("주문 총액: " + orders.getTotalPrice());

                System.out.println("주문한 물품 리스트: ");
                for (OrderDetailDTO detail : orders.getOrderDetailList()){
                    System.out.println("\t상품 코드: " + detail.getProductCode() + ", 수량: " + detail.getQuantity());
                }
                System.out.println("===============================================");
            }
        }
    }

    public List<OrderDetailDTO> selectOrderDetail(String orderId) {
        List<OrderDetailDTO> orderDetailList = orderService.selectOrderDetail(orderId);
        if (orderDetailList.size() == 0){
            System.out.println("주문 내역이 없습니다.");
        } else {
            if (orderDetailList.size() > 1){
                ProductService productService = new ProductService();
                System.out.println("===============================================");
                for (OrderDetailDTO orderDetail : orderDetailList){
                    ProductDTO product = productService.selectProductByCode(orderDetail.getProductCode());
                    System.out.println("상품 코드: " + product.getProductCode() + ", 상품 이름: " + product.getProductName());
                }
                System.out.println("===============================================");
            }
        }

        return orderDetailList;
    }

//    public void selectOrderDetails(Map<String, String> loginInfo) {
//        List<Integer> productCodeList = orderService.selectOrderDetails(loginInfo);
//
//        if (productCodeList.size() == 0){
//            System.out.println("주문 내역이 없습니다.");
//        } else{
//            for (int productCode : productCodeList){
//                System.out.println("===============================================");
//                System.out.println("주문 번호: " + orders.getOrderId());
//                System.out.println("주문 시간: " + orders.getOrderTime());
//                System.out.println("주문 총액: " + orders.getTotalPrice());
//
//                System.out.println("주문한 물품 리스트: ");
//                for (OrderDetailDTO detail : orders.getOrderDetailList()){
//                    System.out.println("\t상품 코드: " + detail.getProductCode() + ", 수량: " + detail.getQuantity());
//                }
//                System.out.println("===============================================");
//            }
//        }
//    }
}
