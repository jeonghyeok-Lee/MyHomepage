package com.argonhome.web.board.dao;

import java.util.List;
import com.argonhome.web.board.model.BoardVO;

// DAO를 만들 때에는 interface를 만들고 interface를 구현하는 형식으로 진행하는 것이 좋음
public interface BoardDAO {
	public List<BoardVO> getBoardList() throws Exception;
	public BoardVO getBoardContent(int bid) throws Exception;
	public int insertBoard(BoardVO boardVO) throws Exception;
	public int updateBoard(BoardVO boardVO) throws Exception;
	public int deleteBoard(int bid) throws Exception;
	public int updateViewCnt(int bid) throws Exception;
	
}
