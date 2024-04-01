package com.orange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.orange.model.Cart;
import com.orange.model.CartItem;
import com.orange.model.Item;
import com.orange.model.Member;
import com.orange.repository.CartMapper;
import com.orange.repository.ItemMapper;

@Service
public class CartService {
	
	@Autowired
	CartMapper cartMapper;
	@Autowired
	ItemMapper itemMapper;

	public void addToCart(@SessionAttribute("loggedInMember") Member member, Long itemId, int quantity, CartItem cartItem) {
		System.out.println("체크");
		System.out.println("세션 체크: "+member.toString());
		Cart cart = cartMapper.findByUserId(member.getId());
		System.out.println("cart 저장: "+cart.toString());
		
		Item item = itemMapper.selectByItemId(itemId);
//		if(cart == null) {
//			cart = cartMapper.createCart(member.getId());
//		} 
			cartMapper.addToCart(cart, quantity);	
	}
}
