package com.orange.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderInfo {

	private Long orderId;
	private Long userId;
	private String createDate;
}
