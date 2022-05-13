package com.jsp.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;

public class MemberDaoImpl implements MemberDAO{

	@Override
	public List<MemberVO> selectMemberList(SqlSession session) throws Exception {
		List<MemberVO>memberList =null;
		
		try {
			memberList = session.selectList("Member-Mapper.selectMemberList");
		} catch (Exception e) {
			//에러처리
			throw e;
		}
		return memberList;
	}

	@Override
	public List<MemberVO> selectMemberList(SqlSession session, Criteria cri) throws Exception {
			int offset = cri.getStartRowNum(); //시작 페이지 글번호
			int limit = cri.getPerPageNum(); // 몇개 단위
			RowBounds rowBounds = new RowBounds(offset,limit); //범주
			
			List<MemberVO>memberList
			     = session.selectList("Member-Mapper.selectMemberList",null,rowBounds);
			
			return memberList;
			
	}

	@Override
	public int selectMemberListCount(SqlSession session) throws Exception {
		int totalCount
		= session.selectOne("Member-Mapper.selectMemberListCount");
		
		return totalCount;
	}

	
	
	
	
}
