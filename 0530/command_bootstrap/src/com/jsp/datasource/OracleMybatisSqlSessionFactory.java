package com.jsp.datasource;

import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

public class OracleMybatisSqlSessionFactory implements SqlSessionFactory {
	
	private SqlSessionFactory sqlSessionFactory;
	
	{
		String config = "com/jsp/mybatis/config/sqlConfig.xml";
		
		try {
			Reader reader = Resources.getResourceAsReader(config);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.println("SqlSessionFactory 성공했습니다.");
		} catch (Exception e) {
			System.out.println("SqlSessionFactory 실패했습니다.");
			e.printStackTrace();
		}
	}

	@Override
	public Configuration getConfiguration() {
		return sqlSessionFactory.getConfiguration(); //케이싱으로 이렇게 간단하게 사용가능하다.
	}

	@Override
	public SqlSession openSession() {
		return sqlSessionFactory.openSession(true); //오토 커밋을 위해서
	}

	@Override
	public SqlSession openSession(boolean arg0) {
		return sqlSessionFactory.openSession(arg0);
	}

	@Override
	public SqlSession openSession(Connection arg0) {
		return sqlSessionFactory.openSession(arg0);
	}

	@Override
	public SqlSession openSession(TransactionIsolationLevel arg0) {
		return sqlSessionFactory.openSession(arg0);
	}

	@Override
	public SqlSession openSession(ExecutorType arg0) {
		return sqlSessionFactory.openSession(arg0);
	}

	@Override
	public SqlSession openSession(ExecutorType arg0, boolean arg1) {
		return sqlSessionFactory.openSession(arg0, arg1);
	}

	@Override
	public SqlSession openSession(ExecutorType arg0, TransactionIsolationLevel arg1) {
		return sqlSessionFactory.openSession(arg0, arg1);
	}

	@Override
	public SqlSession openSession(ExecutorType arg0, Connection arg1) {
		return sqlSessionFactory.openSession(arg0, arg1);
	}

}
