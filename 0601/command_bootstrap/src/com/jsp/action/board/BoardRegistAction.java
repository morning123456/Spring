package com.jsp.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.controller.XSSHttpRequestParameterAdapter;
import com.jsp.controller.XSSResolver;
import com.jsp.dto.BoardVO;
import com.jsp.dto.NoticeVO;
import com.jsp.service.BoardService;
import com.jsp.service.NoticeService;

public class BoardRegistAction implements Action {

	private BoardService boardService;
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}



	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/regist_success";
		
		BoardVO board = XSSHttpRequestParameterAdapter.execute(request, BoardVO.class,true);
		
		//smartEditor parameter제외
		board.setContent(request.getParameter("content"));
		
		boardService.regist(board);
		
		return url;
	}

}
