package com.orange.service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.model.Member;
import com.orange.repository.MemberMapper;

@Service
public class LoginService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	HttpSession httpSession;
	
	public boolean login(String userId, String password) {
		int result = memberMapper.loginCheck(userId, password);
		boolean isLoggedIn = (result !=0);
		if(isLoggedIn) {
			Member member = memberMapper.selectByUserId(userId);
			if(member != null) {
				httpSession.setAttribute("loggedInMember", member);
				System.out.println("로그인 성공");
				return true;
			} 
		} return false;
	}
	public void logout() {
		httpSession.removeAttribute("loggedInMember");
	}
	
}
