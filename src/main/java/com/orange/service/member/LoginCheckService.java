package com.orange.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.repository.MemberMapper;

@Service
public class LoginCheckService {

	@Autowired
	MemberMapper memberMapper;
	
	public int loginCheck(String userId) {
		int result = memberMapper.idCheck(userId);
		return result;
	}
}
