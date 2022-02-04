package com.argonhome.web.board.dao;

import java.util.List;

import com.argonhome.web.board.model.BoardVO;
import com.argonhome.web.common.Pagination;

// DAO�� ���� ������ interface�� ����� interface�� �����ϴ� �������� �����ϴ� ���� ����
public interface BoardDAO {
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception;
	public BoardVO getBoardContent(int bid) throws Exception;
	public int insertBoard(BoardVO boardVO) throws Exception;
	public int updateBoard(BoardVO boardVO) throws Exception;
	public int deleteBoard(int bid) throws Exception;
	public int updateViewCnt(int bid) throws Exception;
	
	public int getBoardListCnt() throws Exception;
}
