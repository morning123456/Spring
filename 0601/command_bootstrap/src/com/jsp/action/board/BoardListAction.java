package com.jsp.action.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.SearchCriteria;
import com.jsp.command.SearchCriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.BoardService;
import com.jsp.service.NoticeService;

public class BoardListAction implements Action {

   private BoardService boardService;
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}


	@Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String url = "/board/list";

      SearchCriteria cri = null;
      try {
         SearchCriteriaCommand command = HttpRequestParameterAdapter.execute(request, SearchCriteriaCommand.class);
         cri = command.toSearchCriteria();

         // 처리
         Map<String, Object> dataMap = boardService.getBoardList(cri);
         request.setAttribute("dataMap", dataMap);
      } catch (Exception e) {
         e.printStackTrace();
         // response.sendError(response.SC_INTERNAL_SERVER_ERROR);
         // url=null;
         throw e;
      }

      // 출력
      return url;
   }

}