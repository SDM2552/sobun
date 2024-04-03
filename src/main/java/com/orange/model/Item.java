package com.orange.model;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Item {

	private Long itemId;
	@NonNull private String category;
	@NonNull private String name;
	@NonNull private int price;
	@NonNull private int quantity;
	@NonNull private int sales;
	@NonNull private String description;
	@NonNull private String image;
	private String regdate;
	private int cartItemQuantity;
}
