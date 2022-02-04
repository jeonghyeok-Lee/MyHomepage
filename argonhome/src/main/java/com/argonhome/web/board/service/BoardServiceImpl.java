package com.argonhome.web.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.argonhome.web.board.dao.BoardDAO;
import com.argonhome.web.board.model.BoardVO;
import com.argonhome.web.common.Pagination;
import com.argonhome.web.error.controller.NotFoundException;

// service�� controller�� ��û�� ���� �ʿ��� ����Ͻ� ������ ó��. �ʿ��Ѱ�� db���� ó���� ����
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
