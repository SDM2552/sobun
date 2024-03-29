package com.orange.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.model.Member;
import com.orange.repository.MemberMapper;

@Service
public class MemberJoinService {

	@Autowired
	MemberMapper memberMapper;
	
	public void insertMember(Member member) {
		memberMapper.insertMember(member);
	}
}
