package com.argonhome.web.board.service;

import java.util.List;

import com.argonhome.web.board.model.BoardVO;
import com.argonhome.web.common.Pagination;

public interface BoardService {
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception;
	public void insertBoard(BoardVO boardVO) throws Exception;
	public BoardVO getBoardContent(int bid) throws Exception;
	public void updateBoard(BoardVO boardVO) throws Exception;
	public void deleteBoard(int bid) throws Exception;
	
	public int getBoardListCnt() throws Exception;
}
