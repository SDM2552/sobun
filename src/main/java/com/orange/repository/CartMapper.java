package com.orange.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.orange.model.Cart;
import com.orange.model.CartItem;

@Mapper
public interface CartMapper {

	int count();

	Cart findByUserId(Long userId);

	@Insert("insert into cart (user_id, created_Time) values(#{userId}, now());")
	void createCart(Long userId);
	
	@Insert("insert into Cart_item (cart_id, item_id, quantity) values( #{cartId}, #{itemId}, #{quantity});")
	void addToCart(Cart cart, int quantity);
	

}
