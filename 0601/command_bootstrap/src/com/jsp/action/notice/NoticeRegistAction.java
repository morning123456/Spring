package com.jsp.action.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.controller.XSSResolver;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

public class NoticeRegistAction implements Action {

	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/notice/regist_success";
		
//		NoticeVO notice = HttpRequestParameterAdapter.execute(request, NoticeVO.class);
//		
//		XSSResolver.parseXSS(request);
//		String title = (String) request.getAttribute("XSStitle");
//		
		NoticeVO notice = XSSHttpRequestParameterAdapter.execute(request, NoticeVO.class,true);
		
		//smartEditor parameter제외
		notice.setContent(request.getParameter("content"));
		
		noticeService.regist(notice);
		
		return url;
	}

}
