package com.java.ot;

public class Proccess {
	
	public String proccess1(String input) {
		String str="";
		
		if(input == null) return null;
		try {
			Integer.parseInt(input);
			//����
			str+="����:";
		}catch(Exception e) {
			str+="����:";
		}
		
		str+=input;
		
		return str;
	}
	public String proccess2(String input) {
		String str=null;
		
		if(input == null) return null;
		try {
			Integer.parseInt(input);
			//����
			str+="Number:";
		}catch(Exception e) {
			str+="String:";
		}
		
		str+=input;
		
		return str;
	}
}
