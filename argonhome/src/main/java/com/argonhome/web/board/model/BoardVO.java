package com.argonhome.web.board.model;

// �����͸� ���� �׸����� Value Object��
// DTO vs VO
// DTO -> ������ ������ ��ȯ�� ���� ���Ǵ� ��ü�� ������ ���� getter/setter�޼ҵ常 ����
// VO  -> �� ��ü�� ǥ���� ��ü��, ���� ����, ��ü�� �Һ����� ����
// Entity -> ���� DB�� ���̺�� ���εǴ� ��ü
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
