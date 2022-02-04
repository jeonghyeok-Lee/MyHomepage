package com.argonhome.web.common;

public class Pagination {
	private int listSize = 20;             	// 페이지당 보여질 리스트(게시물)의 개수 	
	private int rangeSize = 10;            	// 페이지 범위에 보여질 페이지의 개수 -> 1~10
	private int page;						// 현재 페이지 번호
	private int range;						// 현재 페이지의 시작 번호
	private int listCnt;					// 전체 게시물 개수
	private int pageCnt;					// 총 페이지 범위 수
	private int startPage;					// 각 페이지 범위에서 시작될 페이지 번호
	private int startList;					// 현재 페이지에서 시작될 게시물의 번호
	private int endPage;					// 각 페이지 범위 끝 번호
	private boolean prev;					// 이전 페이지 여부
	private boolean next;					// 다음 페이지 여부
	
	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getRangeSize() {
		return rangeSize;
	}

	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getListCnt() {
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getStartList() {
		return startList;
	}

	public void setStartList(int startList) {
		this.startList = startList;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
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

	//
	public void pageInfo(int page, int range,int listCnt) {
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;
		
		this.pageCnt = (int) Math.ceil((double)listCnt/listSize); //반올림
		this.startPage = (range - 1) * rangeSize + 1 ;
		this.endPage = range * rangeSize;
		this.startList = (page - 1) * listSize;		// page - 1인 이유는 조회할 첫번째 글은 1이 아닌 0임(db에서 첫번째 row- 0) 즉 현재 = (페이지번호-1)*페이지 사이즈
		// 이전 버튼 상태 / 현재 시작번호가 1이면 false 아니면 true 반환
		this.prev = range == 1 ? false : true;
		// 다음 버튼 상태 / 마지막 번호가 총 페이지 번호랑 갖다면 false 아니면 true 반환
		this.next = pageCnt > endPage ? true : false;
		if (this.endPage > this.pageCnt) {					// 만약 총 페이지 수보다 마지막번호가 커지게 되면
			this.endPage = this.pageCnt;					// 현재 마지막 번호를 총 페이지 수로 바꿔주고
			this.next = false;								// 다음 페이지 여부를 false로 즉, 마지막 페이지범위에서 번호가 부족하면 버튼을 비활성화
		}
	}
}
