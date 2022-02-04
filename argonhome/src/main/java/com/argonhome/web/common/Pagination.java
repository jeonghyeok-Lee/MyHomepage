package com.argonhome.web.common;

public class Pagination {
	private int listSize = 20;             	// �������� ������ ����Ʈ(�Խù�)�� ���� 	
	private int rangeSize = 10;            	// ������ ������ ������ �������� ���� -> 1~10
	private int page;						// ���� ������ ��ȣ
	private int range;						// ���� �������� ���� ��ȣ
	private int listCnt;					// ��ü �Խù� ����
	private int pageCnt;					// �� ������ ���� ��
	private int startPage;					// �� ������ �������� ���۵� ������ ��ȣ
	private int startList;					// ���� ���������� ���۵� �Խù��� ��ȣ
	private int endPage;					// �� ������ ���� �� ��ȣ
	private boolean prev;					// ���� ������ ����
	private boolean next;					// ���� ������ ����
	
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
		
		this.pageCnt = (int) Math.ceil((double)listCnt/listSize); //�ݿø�
		this.startPage = (range - 1) * rangeSize + 1 ;
		this.endPage = range * rangeSize;
		this.startList = (page - 1) * listSize;		// page - 1�� ������ ��ȸ�� ù��° ���� 1�� �ƴ� 0��(db���� ù��° row- 0) �� ���� = (��������ȣ-1)*������ ������
		// ���� ��ư ���� / ���� ���۹�ȣ�� 1�̸� false �ƴϸ� true ��ȯ
		this.prev = range == 1 ? false : true;
		// ���� ��ư ���� / ������ ��ȣ�� �� ������ ��ȣ�� ���ٸ� false �ƴϸ� true ��ȯ
		this.next = pageCnt > endPage ? true : false;
		if (this.endPage > this.pageCnt) {					// ���� �� ������ ������ ��������ȣ�� Ŀ���� �Ǹ�
			this.endPage = this.pageCnt;					// ���� ������ ��ȣ�� �� ������ ���� �ٲ��ְ�
			this.next = false;								// ���� ������ ���θ� false�� ��, ������ �������������� ��ȣ�� �����ϸ� ��ư�� ��Ȱ��ȭ
		}
	}
}
