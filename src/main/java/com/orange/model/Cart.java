package com.orange.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@Builder
@RequiredArgsConstructor
public class Cart {

	@NonNull private Long cartId;
	 private Long userId;
	 private String createdTime;
}
