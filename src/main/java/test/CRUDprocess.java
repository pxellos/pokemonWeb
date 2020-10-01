package test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CRUDprocess {
//이 클래스의 목적:MyBatis의 매퍼를 호출한다.
//무슨일을 하나? 
//	1. MyBaits환경설정파일을 읽는다.
//  2. 위의 1의 작업으로 매퍼를 호출할 객체(SqlSession)를 생성한다.
//특이사항:SqlSession은 SqlSessionFactory가 생성한다.
//		 SqlSessionFactory는 SqlSessionFactoryBuilder가 생성한다.
//////////////////SqlSession을 만드는 메서드/////////////
	public SqlSession getSession() {
		String path = "test/mybatis_config.xml";// 환경설정파일의 경로
		InputStream is = null;// 파일의 내용을 읽을 객체
		try {
			is = Resources.getResourceAsStream(path);
		} catch (Exception e) {
			System.out.println("환경설정파일을 읽는 중 예외발생");
		} // 예외처리
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession session = factory.openSession();
		return session;
	}


}
