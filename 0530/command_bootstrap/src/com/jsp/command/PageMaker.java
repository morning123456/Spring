package com.jsp.command;

public class PageMaker {
	
	private int totalCount;		//전체 행의 개수
	private int startPage = 1;	//시작 페이지 번호
	private int endPage = 1;	//마지막 페이지 번호	
	private int realEndPage;	//끝 페이지 번호
	private boolean prev;		//이전 페이지 버튼 유무
	private boolean next;		//다음 페이지 버튼 유무
	
	private int displayPageNum = 10;	//한 페이지에 보여줄 페이지 번호 개수
	
	Criteria cri = new Criteria();
	
	
	//startPage, endPage, prev, next 설정. by totalCount
	private void clacData() {
		//endPage : 현재 페이지를 보여줄 페이지 수로 나눈 값을 올림으로 정수화 * 보여줄 페이지 수
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		realEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		
		if(startPage < 0) {
			startPage = 1;
		}
		if(endPage > realEndPage) {
			endPage = realEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage >= realEndPage ? false : true;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//totalCount만 외부데이터가 필요하다.
		//setTotalCount는 외부에서 데이터가 들어오는 시점. 
		//즉 이 타이밍에 clacData()메서드를 돌리면 모든 값이 생성된다.
		clacData(); 
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getRealEndPage() {
		return realEndPage;
	}


	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public int getDisplayPageNum() {
		return displayPageNum;
	}


	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}


	public Criteria getCri() {
		return cri;
	}


	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
	
}
