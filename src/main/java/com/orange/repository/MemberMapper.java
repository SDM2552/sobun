package com.orange.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.orange.model.Item;

@Mapper
public interface MemberMapper {

	@Select("select count(*) from member")
	int count();
	
	@Select("select count(*) from member where user_Id=#{userId}")
	int idCheck(String userId);
	
	int loginCheck(@Param("userId") String userId, @Param("password") Integer password);

}
