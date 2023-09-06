package com.temple202309.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) // 실행을 위한 테스트 클래스 지정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 참고할 설정 파일
@Log4j2 // 신형 로그
public class DataSourceTests {
	
	@Setter( onMethod_ = {@Autowired})//생성자 자동 주입(세터)
	private DataSource dataSource;//객체 생성
	
	@Setter( onMethod_ = {@Autowired})//생성자 자동 주입(세터)
	private SqlSessionFactory sqlSessionFactory;//객체 생성
	
	@Test
	public void testMybatis() {
		try (
				SqlSession session = sqlSessionFactory.openSession();//세션 오픈
				Connection con = session.getConnection();//세션 연결
				) {
				log.info(session);
				log.info(con);
		} catch (Exception e) {//실패 시 
				fail(e.getMessage());
		}//예외처리 블럭 종료
	}//testMybatis 메서드 종료
	
	@Test
	public void testConnection() {
		
		try(Connection con = dataSource.getConnection()){
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}//예외처리 블럭 종료
	}//testConnection 메서드 종료
}//DataSourceTests 클래스 종료
