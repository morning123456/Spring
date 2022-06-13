package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Boolean result = true;
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		if(num!=0) {
			result = false;
		}
		
		return result;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("Model Attribute : " +modelAndView.getModel().get("message"));
		System.out.println("view name : "+modelAndView.getViewName());
		
		modelAndView.addObject("message","Hello Spring!");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if(ex!=null)
			System.out.println("Exception message : "+ex.getMessage());
		
	}

}
