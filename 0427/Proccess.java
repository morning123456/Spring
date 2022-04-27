package com.java.ot;

public class Proccess {
	
	public String proccess1(String input) {
		String str="";
		
		if(input == null) return null;
		try {
			Integer.parseInt(input);
			//숫자
			str+="숫자:";
		}catch(Exception e) {
			str+="문자:";
		}
		
		str+=input;
		
		return str;
	}
	public String proccess2(String input) {
		String str=null;
		
		if(input == null) return null;
		try {
			Integer.parseInt(input);
			//숫자
			str+="Number:";
		}catch(Exception e) {
			str+="String:";
		}
		
		str+=input;
		
		return str;
	}
}
