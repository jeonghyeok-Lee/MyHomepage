package com.argonhome.web.board.model;

// 데이터를 담을 그릇으로 Value Object로
// DTO vs VO
// DTO -> 계층간 데이터 교환을 위해 사용되는 객체로 로직이 없고 getter/setter메소드만 갖음
// VO  -> 값 자체를 표현한 객체로, 로직 포함, 객체의 불변성을 보장
// Entity -> 실제 DB의 테이블과 매핑되는 객체
public class BoardVO {
	private int bid;
	private String bcategory;
	private String btitle;
	private String bcontent;
	private String btag;
	private int bview_cnt;
	private String bwriter;
	private String bwrite_dy;
	private String bedit_dy;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBcategory() {
		return bcategory;
	}
	public void setBcategory(String bcategory) {
		this.bcategory = bcategory;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBtag() {
		return btag;
	}
	public void setBtag(String btag) {
		this.btag = btag;
	}
	public int getBview_cnt() {
		return bview_cnt;
	}
	public void setBview_cnt(int bview_cnt) {
		this.bview_cnt = bview_cnt;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBwrite_dy() {
		return bwrite_dy;
	}
	public void setBwrite_dy(String bwrite_dy) {
		this.bwrite_dy = bwrite_dy;
	}
	public String getBedit_dy() {
		return bedit_dy;
	}
	public void setBedit_dy(String bedit_dy) {
		this.bedit_dy = bedit_dy;
	}
	@Override
	public String toString() {
		return "BoardVO [bid=" + bid + ", bcategory=" + bcategory + ", btitle=" + btitle + ", bcontent=" + bcontent
				+ ", btag=" + btag + ", bview_cnt=" + bview_cnt + ", bwriter=" + bwriter + ", bwrite_dy=" + bwrite_dy
				+ ", bedit_dy=" + bedit_dy + "]";
	}
}
