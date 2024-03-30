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
	
	@NonNull private Long cartItemId;
	@NonNull private Long itemId;
	@NonNull private int quantity;

}
