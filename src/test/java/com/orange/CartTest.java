package com.orange;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.orange.model.Cart;
import com.orange.repository.CartMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class CartTest {

	@Autowired
	CartMapper cartMapper;
	
	@Test
	void test00() {
		cartMapper.count();
	}
	@Test
	@DisplayName("카트 찾기(외않됨?)")
	void test01() {
		cartMapper.findByUserId(1L);
	}
	@Test
	@DisplayName("그럼 얘는 되냐?")
	void test03() {
		cartMapper.findByItemId(1L);
	}
	@Test
	@DisplayName("카트 추가")
	@Transactional
	void test02() {
		cartMapper.createCart(1L);
	}

	
	
	
}
