package com.orange.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CartItem {
	
	private Long cartItemId;
	private Long cartId;
	private Long itemId;
	private int quantity;

}
