package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;

public class DispatcherServlet extends HttpServlet {
	
	private HandlerMapper handlerMapper;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String path = config.getInitParameter("url.properties");
		
		try {
			if(path != null) {
				handlerMapper = new HandlerMapper(path); //initParam에 path를 등록해놨으면 경로를 바꿔서 생성하고
			} else {
				handlerMapper = new HandlerMapper(); //initParam에 path가 없으면 기본 경로로 생성한다.
			}
			System.out.println("[DispatcherServlet] handlerMapper가 준비되었습니다.");
		} catch (Exception e) {
			System.out.println("[DispatcherServlet] handlerMapper가 실패했습니다.");
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 URI 검출
		String command = request.getRequestURI(); //contextPath 포함.
		if(command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
		}
		
		//commandHandler 실행
		Action action = null;
		String view = null;
		
		if(handlerMapper != null) {
			action = handlerMapper.getAction(command);
			if(action != null) { //올바른 요청
				try {
					view = action.process(request, response);
					
					if(view == null) {
						return;
					}
					
					request.setAttribute("viewName", view);
					InternalViewResolver.view(request, response);
					
				} catch (Exception e) { //action의 exception
					e.printStackTrace();
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); //500
				}
			} else { //잘못된 요청
				response.sendError(HttpServletResponse.SC_NOT_FOUND); //400, 404
			}
		} else { //핸들러 null
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); //500
		}
	}
}



















