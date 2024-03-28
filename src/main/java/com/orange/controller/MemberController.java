package com.orange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.orange.service.member.LoginCheckService;



@Controller
public class MemberController {

	@Autowired
	private LoginCheckService loginCheckService;
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	@PostMapping("/login")
	public String login() {
		return "";
	}
}
