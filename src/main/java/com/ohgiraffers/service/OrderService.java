package com.ohgiraffers.service;

import com.ohgiraffers.dao.OrderMapper;
import com.ohgiraffers.dto.OrdersOrderDetailDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class OrderService {
    private OrderMapper mapper;

    public int insertOrder(Map<String, String> map) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(OrderMapper.class);

        String memberId = map.get("memberId");
        int result = mapper.insertOrders(memberId);

        if (result > 0){
            int orderId = mapper.selectLastOrderId();

            int n = (map.size()-1)/2;
            int totalPrice = 0;
            for (int i = 0; i < n; i++){
                Map<String,String> inputMap = new HashMap<>();

                inputMap.put("orderId", Integer.toString(orderId));
                inputMap.put("productCode", map.get("productCode" + i));
                inputMap.put("quantity", map.get("quantity" + i));

                // product에서 주문한 quantity만큼 줄이기
                result = mapper.updateProductQuantity(inputMap);

                if (result > 0){
                    // product의 재고가 충분하면 주문 진행
                    result = mapper.insertOrderDetail(inputMap);
                } else{
                    System.out.println("재고가 부족합니다.");
                    break;
                }

                // product price 계산
                totalPrice += (mapper.getProductPrice(inputMap) * Integer.parseInt(inputMap.put("quantity", map.get("quantity" + i))));
            }

            if (result > 0){
                // orders 테이블에 total_price 업데이트
                Map<String,String> inputMap2 = new HashMap<>();
                inputMap2.put("orderId", Integer.toString(orderId));
                inputMap2.put("totalPrice", Integer.toString(totalPrice));
                result = mapper.updateOrderTotalPrice(inputMap2);
            }
        }

        if (result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result;
    }

    public List<OrdersOrderDetailDTO> selectOrderHistory(Map<String, String> loginInfo) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(OrderMapper.class);

        List<OrdersOrderDetailDTO> ordersList = mapper.selectOrderHistory(loginInfo);

        sqlSession.close();

        return ordersList;
    }
}
