package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("안녕하세요");
		
		// localhost/Servlet_01/test
		response.setContentType("application/html;charset=utf-8");
		
		response.getWriter().println("<h1>안녕하세요</h1>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
