package com.jsp.service;

import java.util.List;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;

public interface MemberService {

	public List<MemberVO> getMemberList()throws Exception;
	public List<MemberVO> getMemberList(Criteria cri)throws Exception;

	public Map<String, Object> getMemberListForPage(Criteria cri)throws Exception;
	
	
}
