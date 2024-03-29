package com.orange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.orange.model.Member;
import com.orange.service.member.LoginService;
import com.orange.service.member.MemberJoinService;



@Controller
public class MemberController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private MemberJoinService memberJoinService;
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	@PostMapping("/login")
	public String login(Member member) {
		boolean isLoggedIn  = loginService.login(member.getUserId(), member.getPassword());
		System.out.println("로그인 체크한다: "+isLoggedIn);
		return "root";
	}
	@GetMapping("logout")
	public String logout() {
		loginService.logout();
		return "redirect:/logoutSuccess";
	}
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	@GetMapping("/signUp")
	public String SignUpForm() {
		return "signUpForm";
	}
	@PostMapping("/signUp")
	public String signUp(Member member) {
		memberJoinService.insertMember(member);
		System.out.println("회원가입 성공");
		return "root";
	}
}
