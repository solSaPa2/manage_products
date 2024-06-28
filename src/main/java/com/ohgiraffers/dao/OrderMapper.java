package com.ohgiraffers.dao;

import java.util.Map;

public interface OrderMapper {
    int insertOrders(String memberId);

    int selectLastOrderId();

    int insertOrderDetail(Map<String, String> map);


}
