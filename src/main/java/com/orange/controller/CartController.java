package com.orange.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.orange.model.Cart;
import com.orange.model.CartItem;
import com.orange.model.Item;
import com.orange.model.Member;
import com.orange.repository.ItemMapper;
import com.orange.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private ItemMapper itemMapper;
	
    @PostMapping("/addToCart") // 물건 장바구니에 넣기
    public String addToCart(@SessionAttribute("loggedInMember") Member member,
                            @RequestParam("itemId") Long itemId,
                            @RequestParam("quantity") int quantity) {
    	Long userId = member.getId();
        cartService.addCart(userId, itemId, quantity);
        return "redirect:/user/" + userId + "/cart"; 
    }
    
    @GetMapping("/user/{userId}/cart") // 장바구니 페이지
    public String getUserCart(@PathVariable("userId") Long userId, Model model) {
    	// 유저의 카트에 담긴 아이템 정보 가져오기
        List<Item> itemsInCart = cartService.getCartAndItems(userId);
        // 뷰에 아이템 정보 전달
        model.addAttribute("itemsInCart", itemsInCart);

        return "cart";
    }
    
    @PostMapping("deleteCartItem")
    public String deleteCartItem(@RequestBody Map<String, Long> requestData) {
        Long userId = requestData.get("userId");
        Long itemId = requestData.get("itemId");
        cartService.deleteCartItem(itemId, userId);
        return "redirect:/user/" + userId + "/cart";
    }
    
    
    
    
}
