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
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, REGDATE) " +
                "VALUES ('과일', '사과', 1000, 10, 0, '맛있다', '이미지 링크', CURRENT_DATE)");
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, REGDATE) " +
                "VALUES ('과일', '딸기', 1000, 55, 0, '달콤하다', '이미지 링크', CURRENT_DATE)");
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, REGDATE) " +
                "VALUES ('디저트', '홍삼캔디', 500, 999, 0, '건강에 좋다', '이미지 링크', 2024-01-01)");
		jdbcTemplate.execute("INSERT INTO item (CATEGORY, NAME, PRICE, QUANTITY, SALES, DESCRIPTION, IMAGE, REGDATE) " +
				"VALUES ('야채', '대파', 1500, 20, 0, '신선합니다', '이미지 링크', 2024-01-03)");
		//member
		jdbcTemplate.execute("INSERT INTO member (user_Id, password, name, email, point) " +
				"VALUES ('asd', 1234, '테스트01', 'test@naver.com', 100)");
		
	}

}
