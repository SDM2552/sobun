package com.orange;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.orange.model.Member;
import com.orange.repository.ItemMapper;
import com.orange.repository.MemberMapper;
import com.orange.service.member.LoginService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class MemberTest {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	private LoginService loginService;
	
	@Test
	void test05() {
		System.out.println("로그인 체크: "+memberMapper.loginCheck("asd", "1234"));
	}
	@Test
	@DisplayName("로그인 체크")
	void contextLoads() {
		System.out.println("로그인 성공?: "+loginService.login("asd", "1234"));
	}
	@Test
	@Transactional
	@DisplayName("회원가입 체크")
	void test06() {
		Member memeber = Member.builder()
				.userId("qwe")
				.password("1234")
				.name("쿼티")
				.email("qwe@emai.com")
				.build();
		memberMapper.insertMember(memeber);
	}
}
