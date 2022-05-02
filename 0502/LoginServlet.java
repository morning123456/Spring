package com.jsp.comtroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/common/login.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 입력 (id/pwd)
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		String message = "";
		
		
		// 로그인 처리
		if(id!=null && id.equals("mimi")) { 
			if(pwd !=null && pwd.equals("mimi")) { // 로그인성공
				message="로그인 성공입니다.";
			}else {//암호 불일치
				message="패스워드가 일치하지 않습니다.";
			}
		}else { // 아이디 불일치
			message="아이디가 존재하지 않습니다.";
		}
		
		//출력.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('"+message+"');");
		out.println("</script>");
	}

}










