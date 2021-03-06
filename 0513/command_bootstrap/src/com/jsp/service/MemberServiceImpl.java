package com.jsp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDaoImpl;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;

public class MemberServiceImpl implements MemberService{

	private SqlSessionFactory sqlSessionFactory
		= new OracleMybatisSqlSessionFactory();
	
	private MemberDAO memberDAO = new  MemberDaoImpl();
	
	public List<MemberVO> getMemberList() throws Exception{
		SqlSession session = sqlSessionFactory.openSession(false); // false를 함으로써 오토커밋을 막아줌
		List<MemberVO>memberList = null;
		
		try {
			memberList = memberDAO.selectMemberList(session);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(session!=null)session.close();
		}
		return memberList;
	}

	@Override
	public List<MemberVO> getMemberList(Criteria cri) throws Exception {
		
		SqlSession session = sqlSessionFactory.openSession(false);
		List<MemberVO>memberList = null;
		
		try {
			memberList = memberDAO.selectMemberList(session,cri);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(session!=null)session.close();
		}
		return memberList;
	}

	@Override
	public Map<String, Object> getMemberListForPage(Criteria cri) throws Exception {
		SqlSession session = sqlSessionFactory.openSession(false);
		Map<String,Object>dataMap = null;
		
		try {
			
			//처리......
			List<MemberVO>memberList
				= memberDAO.selectMemberList(session,cri);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(memberDAO.selectMemberListCount(session));
			
			dataMap = new HashMap<String, Object>();
			dataMap.put("memberList", memberList);
			dataMap.put("pageMaker", pageMaker);
			
			session.commit();
					
			
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(session!=null)session.close();
		}
		return dataMap;
	}
}
