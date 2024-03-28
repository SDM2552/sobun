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
public class Member {

	private Long id;
	@NonNull private String userId;
	@NonNull private String password;
	@NonNull private String name;
	@NonNull private String email;
	private int point;
}

