package com.orange.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@Builder

public class Cart {

	private Long cartId;
	private Long userId;
	private int count;
	private List<CartItem> cartItems;
	private Item item;

	private Long itemId;
	private Long cartItemId;
	private Integer quantity;
	
	public List<CartItem> getCartItems() {
        return cartItems;
    }
    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
	public Cart(Long userId) {
		this.userId = userId;
	}
	public void setItem(Item item) {
        this.item = item;
    }
	public Cart(Long cartId, Long userId, int count) {
		this.cartId = cartId;
		this.userId = userId;
		this.count = count;
	}
	public Cart(Long cartId, Long userId, int count, Long itemId, Long cartItemId, Integer quantity) {
		this.cartId = cartId;
		this.userId = userId;
		this.count = count;
		this.itemId = itemId;
		this.cartItemId = cartItemId;
		this.quantity = quantity;
	}
}
