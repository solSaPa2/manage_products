package com.ohgiraffers.dao;

import com.ohgiraffers.dto.OrdersOrderDetailDTO;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int insertOrders(String memberId);

    int selectLastOrderId();

    int insertOrderDetail(Map<String, String> map);

    List<OrdersOrderDetailDTO> selectOrderHistory(Map<String, String> loginInfo);

    int updateProductQuantity(Map<String, String> map);

    int getProductPrice(Map<String, String> map);

    int updateOrderTotalPrice(Map<String, String> inputMap2);
}
