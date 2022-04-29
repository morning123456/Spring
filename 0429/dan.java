package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dan
 */
@WebServlet("/gugudan")
public class dan extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// localhost/Servlet_01/gugudan?dan=10
		// 입력
		String danStr = request.getParameter("dan");
		int dan = -1;
		String result = "";
		boolean flag = true;

		try {
			dan = Integer.parseInt(danStr);
		} catch (Exception e) {
			flag = false;
		}

		// 처리
		if (flag) {
			for (int gop = 1; gop < 10; gop++) {
				result += dan + " * " + gop + " = " + (dan * gop) + "<br/>";
			}
		} else {
			result += "<script>alert('올바르지않은 입력입니다.\\n정수를 입력하세요.');</script>";
		}
		
		request.setAttribute("dan", dan);
		request.setAttribute("result", result);
		request.setAttribute("flag",flag);
		
		view(request,response);

	}

	private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int dan =(int)request.getAttribute("dan");
		String result = (String)request.getAttribute("result");
		boolean flag = (boolean)request.getAttribute("flag");
		
		// 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + dan + "단" + "</title>");
		out.println("</head>");
		out.println("<body>");
		if (flag)
			out.println("<h1>" + dan + "단 입니다." + "</h1>");
		out.println(result);
		out.println("</body>");
		out.println("</html>");
	}
}
