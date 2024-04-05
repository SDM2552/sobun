package com.orange.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.model.OrderInfo;
import com.orange.model.OrderItem;
import com.orange.repository.OrderMapper;


@Service
public class OrderService {
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	OrderSessionService orderSessionService;
	
	public void viewOrder(List<OrderItem> selectedItems, HttpSession session) {
        orderSessionService.saveSelectedItemsToSession(session, selectedItems);

    }
	
	@Transactional
	public void addOrder(List<OrderItem> selectedItems) {
		// OrderInfo 객체 생성
		OrderInfo orderInfo = new OrderInfo(selectedItems.get(0).getUserId());
		orderMapper.save(orderInfo);
		System.out.println("주문정보: "+orderInfo);
		 // OrderItem에 orderId 설정 후 추가
	    for (OrderItem item : selectedItems) {
	        item.setOrderId(orderInfo.getOrderId());
	    }
	    orderInfo.setOrderItems(selectedItems);

	    // 주문 정보와 주문 항목들을 저장
//	    orderMapper.saveOrderInfo(orderInfo);
	    orderMapper.saveOrderItems(selectedItems);
	 // 저장된 주문 항목 리스트를 가져와서 콘솔에 출력
        List<OrderItem> savedItems = orderMapper.getOrderItemsByOrderId(orderInfo.getOrderId());
        for (OrderItem item : savedItems) {
            System.out.println("저장된 OrderItem: " + item);
        }
	}

}
