package com.orange;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.orange.repository.ItemMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class SobunApplicationTests {

	@Autowired
	private ItemMapper itemMapper;
	
	@Test
	void contextLoads() {
		System.out.println(itemMapper.selectCount());
		log.debug("★count: {}",itemMapper.selectCount());
	}
	@Test
	@DisplayName("전부 출력 테스트")
	void test01() {
		log.debug("★selectAll: {}",itemMapper.selectAll());
	}
	@Test
	@DisplayName("품목 이름으로 검색")
	void test02() {
		log.debug("★이름으로 검색: {}",itemMapper.selectByItemName("사과"));
	}

}
