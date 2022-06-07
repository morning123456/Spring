package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.cal.Calculator;
import com.spring.module.ExtraSummation;

public class Main {

	public static void main(String[] args) {
		
		//Calculator cal = new  Calculator();
		
		ApplicationContext ctx = new GenericXmlApplicationContext(args[0]);
		
		Calculator cal = ctx.getBean("cal",Calculator.class);
		
		int a = 10;
		int b = 5;
		
		System.out.println(a+"+"+b+"="+cal.sum(a, b));
		System.out.println(a+"-"+b+"="+cal.minus(a, b));
		System.out.println(a+"*"+b+"="+cal.multi(a, b));
		System.out.println(a+"/"+b+"="+cal.div(a, b));
				
	}
}
