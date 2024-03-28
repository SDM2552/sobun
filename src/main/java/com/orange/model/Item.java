package com.orange.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Item {

	private Long itemId;
	@NonNull private String category;
	@NonNull private String name;
	@NonNull private double price;
	@NonNull private int quantity;
	@NonNull private String description;
	@NonNull private String image;
	@NonNull private String regdate;
}
