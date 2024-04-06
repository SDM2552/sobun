package com.orange.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.model.OrderItem;
import com.orange.model.OrderSummary;
import com.orange.repository.OrderMapper;

@Service
public class MypageService {

	@Autowired
	OrderMapper orderMapper;
	
	public List<OrderSummary> getOrderList(Long userId) {
        // 주문 목록 조회
        return orderMapper.getOrderSummary(userId);
    }
	


}
