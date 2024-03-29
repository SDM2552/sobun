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
public class Member {

	private Long id;
	@NonNull private String userId;
	@NonNull private String password;
	@NonNull private String name;
	@NonNull private String email;
	private String adress;
	private int point;
}

