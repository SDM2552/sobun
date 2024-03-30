package com.orange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orange.model.CartItem;
import com.orange.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping
	public String addToCart(@RequestParam quantity, @RequestParam itemId  ) {
		cartService.addToCart(quantity, itemId);
		return "";
	}
}
