package com.orange.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.orange.model.Item;
import com.orange.model.Member;

@Mapper
public interface MemberMapper {

	@Select("select count(*) from member")
	int count();
	
	@Select("select * from member where user_Id=#{userId}")
	Member selectByUserId(String userId);
	
	int loginCheck(@Param("userId") String userId, @Param("password") String password);
	
	void insertUser(Member memeber);

}
