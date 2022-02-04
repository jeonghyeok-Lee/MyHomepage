package com.argonhome.web.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.argonhome.web.board.dao.BoardDAO;
import com.argonhome.web.board.model.BoardVO;
import com.argonhome.web.common.Pagination;
import com.argonhome.web.error.controller.NotFoundException;

// service는 controller의 요청에 따라 필요한 비즈니스 로직을 처리. 필요한경우 db관련 처리를 진행
@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception {
		return boardDAO.getBoardList(pagination);
	}
	
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception{
		boardDAO.insertBoard(boardVO);
	}

	@Transactional
	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO = boardDAO.getBoardContent(bid);    
		return boardVO;
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}

	@Override
	public void deleteBoard(int bid) throws Exception {
		boardDAO.deleteBoard(bid);
		
	}

	@Override
	public int getBoardListCnt() throws Exception {
		return boardDAO.getBoardListCnt();
	}
}
