package com.bizpoll.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private static SqlSessionFactory sqlSessionFactory;
	
	//static 초기화 : 해당되는 클래스가 로딩될때 딱 한번 실행되게끔 한다. (자주쓰이지는 않음)
	static {
		String resource = "com/bizpoll/mybatis/Configuration.xml";
		
		
		try {
			Reader reader= Resources.getResourceAsReader(resource);
			
			if(sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
}
