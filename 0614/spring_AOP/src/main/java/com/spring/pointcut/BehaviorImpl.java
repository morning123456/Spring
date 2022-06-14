package com.spring.pointcut;

public class BehaviorImpl implements Behavior {

	@Override
	public void 잠자기() {
		System.out.println("쿨쿨.. 잠을 잔다");

	}

	@Override
	public void 공부하기() {
		System.out.println("열심히 공부하기");
	}

	@Override
	public void 밥먹기() {
		System.out.println("냠냠냠... 맛있게 먹기");

	}

	@Override
	public void 데이트() {
		System.out.println("귀찮아...데이트");

	}

	@Override
	public void 운동() {
		System.out.println("숨쉬기 운동..");

	}

	@Override
	public void 놀기() {
		System.out.println("놀러간다~");

	}

	@Override
	public void 정신수양() {
		System.out.println("명상하기");

	}

}
