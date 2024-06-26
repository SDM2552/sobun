package com.orange;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestRunner implements ApplicationRunner{

	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Connection connection = dataSource.getConnection();
		log.info("■DBCP: "+dataSource.getClass()); //사용하는 DBCP 타입 확인
		log.info("■Url: "+connection.getMetaData().getURL());
		log.info("■UserName: "+ connection.getMetaData().getUserName());
		
		//JdbcTemplete
		//item
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, IMAGE_PATH, REGDATE) " +
                "VALUES ('과일', '사과', 1000, 10, 0, '맛있다','apple.jpg', '/itemImg/apple.jpg', CURRENT_DATE)");
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, IMAGE_PATH, REGDATE) " +
                "VALUES ('과일', '딸기', 1000, 55, 0, '달콤하다','strawberry.jpg', '/itemImg/strawberry.jpg', CURRENT_DATE)");
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, IMAGE_PATH, REGDATE) " +
                "VALUES ('디저트', '홍삼캔디', 500, 999, 0, '건강에 좋다','hongsam.png', '/itemImg/hongsam.png', 2024-01-01)");
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, IMAGE_PATH, REGDATE) " +
				"VALUES ('야채', '대파', 1500, 20, 0, '신선합니다','greenOnion.png', '/itemImg/greenOnion.png', 2024-01-03)");
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, IMAGE_PATH, REGDATE) " +
				"VALUES ('냉동식품', '쫀득한입감자', 4500, 20, 0, '쫀득해요','potato.png', '/itemImg/potato.png', 2024-01-05)");
		//member
		jdbcTemplate.execute("INSERT INTO member (user_Id, password, name, email, point) " +
				"VALUES ('asd', 1234, '테스트01', 'test@naver.com', 100)");
		jdbcTemplate.execute("INSERT INTO member (user_Id, password, name, email, point) " +
				"VALUES ('asd2', 1234, '테스트02', 'test2@naver.com', 200)");
		//cart
		jdbcTemplate.execute("INSERT INTO cart (user_id, count) "
				+ "VALUES ( 1, 0)");
		//cartItem
		jdbcTemplate.execute("INSERT INTO cart_item (cart_id, item_id, quantity) "
				+ "VALUES ( 1, 1, 10)");
		
	}

}
