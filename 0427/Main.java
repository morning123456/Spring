package com.java.ot;

public class Main {
	
	private Input inputIns=new Input();
	private Proccess proccessIns = new Proccess();
	private Output outputIns =new Output();
	
	
	public static void main(String[] args) {		
		Main main = new Main();
		
		//�Է�
		String input = main.inputIns.input1();
				
		//ó��
		String result = main.proccessIns.proccess1(input);
		
		//���
		main.outputIns.output2(result);

	}


}










