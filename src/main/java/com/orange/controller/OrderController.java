package com.orange.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		// 기존 세션에 저장된 selectedItems가 있다면 제거
	    httpSession.removeAttribute("selectedItems");
		// 주문 정보를 세션에 저장
	    httpSession.setAttribute("selectedItems", selectedItems);
	    // 주문 페이지로 이동
	    return "redirect:/order";
	}
	@GetMapping("/order")
	public String showOrderPage(HttpSession httpSession, Model model) {
		 // 세션에서 주문 정보를 가져옴
	    List<OrderItem> selectedItems = (List<OrderItem>) httpSession.getAttribute("selectedItems");
	    // 모델에 주문 정보를 추가하여 화면에 전달
	    model.addAttribute("selectedItems", selectedItems);
	    System.out.println("주문 정보: " + selectedItems);
	    return "order"; 
	}
	@PostMapping("/orderComplete")
	public String orderComplete(Model model, HttpSession httpSession) {
		// 세션에서 주문 정보를 가져옴
	    List<OrderItem> selectedItems = (List<OrderItem>) httpSession.getAttribute("selectedItems");
	    // 모델에 주문 정보를 추가하여 화면에 전달
	    model.addAttribute("selectedItems", selectedItems);
	    orderService.addOrder(selectedItems);
	    //주문 완료 후 세션 제거
	    httpSession.removeAttribute("selectedItems");
		return "redirect:/orderComplete";
	}
	@GetMapping("/orderComplete")
	public String orderCompleteAfter() {
		return "orderComplete";
	}
}
