package com.java.ot;

import java.util.Scanner;

public class Input {
	

	public String input1() {

		Scanner scan = new Scanner(System.in);		
		String input = scan.nextLine();
		
		return input;
	}
	
	public String input2() {

		Scanner scan = new Scanner(System.in);		
		String input1 = scan.nextLine();
		String input2 = scan.nextLine();
		
		return input1+input2;
	}
}
