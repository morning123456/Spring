package com.spring.module;

public class ExtraSummation extends Summation {

	@Override
	public int sum(int a, int b) {
		return super.sum(a, b)+10;
	}
	
	
	public int sum(int a, int b, int c) {
		return super.sum(a, b)+c;
	}
}
