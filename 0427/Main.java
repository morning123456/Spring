package com.java.ot;

public class Main {
	
	private Input inputIns=new Input();
	private Proccess proccessIns = new Proccess();
	private Output outputIns =new Output();
	
	
	public static void main(String[] args) {		
		Main main = new Main();
		
		//입력
		String input = main.inputIns.input1();
				
		//처리
		String result = main.proccessIns.proccess1(input);
		
		//출력
		main.outputIns.output2(result);

	}


}










