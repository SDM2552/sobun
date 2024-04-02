package com.orange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.orange.model.Cart;
import com.orange.model.CartItem;
import com.orange.model.Member;
import com.orange.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
    @PostMapping("/addToCart")
    public String addToCart(@SessionAttribute("loggedInMember") Member member,
                            @RequestParam("itemId") Long itemId,
                            @RequestParam("quantity") int quantity) {
    	Long userId = member.getId();
        cartService.addCart(userId, itemId, quantity);
        return "redirect:/user/" + userId + "/cart"; // 사용자의 장바구니 페이지로 리다이렉트
    }
    
    @GetMapping("/user/{userId}/cart")
    public String getUserCart(@PathVariable("userId") Long userId, Model model) {
        // 서비스를 통해 사용자의 장바구니 정보를 가져옴
        List<Cart> carts = cartService.getCartAndItems(userId);
        // 뷰에 장바구니 정보를 전달
        model.addAttribute("carts", carts);
        // 장바구니 뷰로 이동
        return "cart";
    }
	
}
