package com.orange.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.orange.model.Cart;
import com.orange.model.CartItem;

@Mapper
public interface CartMapper {

	int count();

	Cart findByUserId(Long userId);

	@Insert("insert into cart (user_id) values(#{userId});")
	void createCart(Long userId);

	@Insert("insert into Cart_item (cart_id, item_id, quantity) values( #{cartId}, #{itemId}, #{quantity});")
	void addToCart(Cart cart, int quantity);

	void createCartItem(@Param("cartId") Long cartId, @Param("itemId") Long itemId, @Param("quantity") int quantity);

	CartItem findCartItemByCartIdAndItemId(@Param("cartId") Long cartId, @Param("itemId") Long itemId);

	@Select("select * from cart_item where item_id=#{itemId}")
	CartItem findByItemId(Long itemId);

	Integer findCountByCartIdAndItemId(@Param("cartId") Long cartId, @Param("itemId") Long itemId);

	void save(Cart cart);

	void insertCartItem(CartItem cartItem);

	void updateItemCount(@Param("cartId") Long cartId, @Param("itemId") Long itemId, @Param("quantity") int quantity);

	void updateCartItemCount(@Param("cartId") Long cartId, @Param("quantity") int quantity);
	
	List<Cart> getCartAndItems(@Param("userId") Long userId);
}
