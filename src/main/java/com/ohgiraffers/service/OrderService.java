package com.ohgiraffers.service;

import com.mysql.cj.protocol.x.XProtocolDecoder;
import com.ohgiraffers.dao.MemberMapper;
import com.ohgiraffers.dao.OrderMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.HashMap;
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
            for (int i = 0; i < n; i++){
                Map<String,String> inputMap = new HashMap<>();

                inputMap.put("orderId", Integer.toString(orderId));
                inputMap.put("productCode", map.get("productCode" + i));
                inputMap.put("quantity", map.get("quantity" + i));

                result = mapper.insertOrderDetail(inputMap);
                if (result == 0){
                    break;
                }

                // TODO: product에서 quantity만큼 줄이기

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
}
