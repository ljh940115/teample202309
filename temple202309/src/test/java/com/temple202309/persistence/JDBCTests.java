package com.temple202309.persistence;

import static org.junit.Assert.fail; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2//로그 출력
public class JDBCTests {//테스트는 메서드 선택, Junit 테스트 실행
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("JDBCTests.static 블럭 오류");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
	
		try (
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",//경로 
					"temple2023091",//ID
					"tp2023091")) {//PW
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());//junit 테스트 실패 전달
		}
	}
}
