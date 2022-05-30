package com.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InternalViewResolver {
	public static void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = (String)request.getAttribute("viewName"); // 어트리뷰트에 심어준 값을 꺼내서
		
		if(url == null) {
			return;
		}
		
		if(url.indexOf("redirect:") > -1) { //redirect: 가 붙어있으면 redirect
			String contextPath = request.getContextPath();
			
			url = contextPath + url.replace("redirect:", "");
			
			response.sendRedirect(url);
		} else { // 없으면 forward
			String prefix = "/WEB-INF/views";
			String subfix = ".jsp";
			url = prefix + url + subfix;
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
