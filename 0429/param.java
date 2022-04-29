package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class param
 */
@WebServlet("/param")
public class param extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String color = request.getParameter("color");
	
	System.out.println(color);
	// localhost/Servlet_01/param?color=red
	
	
	response.setContentType("text/html;charset=utf-8");
	
	//브라우저 - 나
	response.getWriter().println(color);

	//브라우저 - sem
	PrintWriter out = response.getWriter();
	out.println(color);
	
	// 나
	//out.println("<style>body{background:red;}</style>");
	
    //sem
	out.println("<style>");
	out.println("body{background:");
	out.println(color);
	out.println("}");
	out.println("</style>");
	
	}

	
}
