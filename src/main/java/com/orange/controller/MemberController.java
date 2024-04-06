package com.orange.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.orange.model.Member;
import com.orange.model.OrderSummary;
import com.orange.service.member.LoginService;
import com.orange.service.member.MemberJoinService;
import com.orange.service.member.MypageService;



@Controller
public class MemberController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private MemberJoinService memberJoinService;
	@Autowired
	private MypageService mypageService;
	
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
	@GetMapping("/loginCheck")
	public String loginFirst() {
		return "loginCheck";
	}
	@GetMapping("logout")
	public String logout() {
		loginService.logout();
		return "logoutSuccess";
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
	@GetMapping("/MyPage/orderList")
	public String orderList(Model model, HttpSession httpSession) {
		 // 세션에서 로그인된 회원 정보 가져오기
		Member loggedInMember = (Member) httpSession.getAttribute("loggedInMember");
	    Long userId = loggedInMember.getId();
	    List<OrderSummary> orderList = mypageService.getOrderList(userId); // 주문 목록 가져오기
	    model.addAttribute("orderList", orderList); // 모델에 주문 목록 추가
		return "myPage_OrderList";
	}
}
