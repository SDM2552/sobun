package com.orange;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.orange.model.Item;
import com.orange.repository.ItemMapper;
import com.orange.repository.MemberMapper;
import com.orange.repository.OrderMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class SobunApplicationTests {

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private OrderMapper orderMapper;
	
	@Test
	@DisplayName("order 테이블 출력 테스트")
	void test10() {
		orderMapper.count();
	}
	
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
		log.debug("★이름으로 검색: {}",itemMapper.selectByItemId(1L));
	}
	
	@Test
	void test03() {
		log.debug("첫 작동 테스트: {}",memberMapper.count());
	}
	@Test
//	@Transactional
	@DisplayName("상품 등록 테스트")
	void test06() {
		Item item = Item.builder()
					.category("과일")
					.name("멜론")
					.price(5000)
					.quantity(30)
					.description("맛있어요")
					.image("아직 없음")
					.build();
		itemMapper.insertItem(item);
	}
	@Test
	void test04() {
		System.out.println("ID로 값 가져오기 테스트: "+memberMapper.selectByUserId("asd"));
	}
	@Test
	void test05() {
		System.out.println("로그인 체크: "+memberMapper.loginCheck("asd", "1234"));
	}

}
