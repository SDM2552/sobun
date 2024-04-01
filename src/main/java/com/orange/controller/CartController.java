package com.orange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.orange.model.CartItem;
import com.orange.model.Member;
import com.orange.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/addToCart")
	public String addToCart(@SessionAttribute("loggedInMember") Member member, Long itemId, int quantity, CartItem cartItem) {
		cartService.addToCart(member, itemId, quantity, cartItem);
		System.out.println("카트에 담았습니다.");
		return "cart";
	}
	
}
