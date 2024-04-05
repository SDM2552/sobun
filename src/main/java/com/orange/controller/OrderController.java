package com.orange.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.orange.model.OrderItem;
import com.orange.service.OrderService;



@Controller
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping("/user/{userId}/order")
	public String processOrder(@RequestBody List<OrderItem> selectedItems, HttpSession httpSession) {
		System.out.println("출력 테스트: "+selectedItems);
		// 주문 정보를 세션에 저장
	    httpSession.setAttribute("selectedItems", selectedItems);
	    // 주문 페이지로 이동
	    return "redirect:/order";
	}
	@GetMapping("/order")
	public String showOrderPage() {
	    return "order"; // order.jsp 경로를 반환합니다.
	}
}
