package com.argonhome.web.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.argonhome.web.board.dao.BoardDAO;
import com.argonhome.web.board.model.BoardVO;
import com.argonhome.web.error.controller.NotFoundException;

// service는 controller의 요청에 따라 필요한 비즈니스 로직을 처리. 필요한경우 db관련 처리를 진행
@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> getBoardList() throws Exception {
		return boardDAO.getBoardList();
	}
	
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception{
		boardDAO.insertBoard(boardVO);
	}

	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO = boardDAO.getBoardContent(bid);    
		boardVO.setBid(bid);
		boardVO.setBcategory("11111111111111111111111111111111111111111111111111111111");
		boardDAO.updateBoard(boardVO);
//		try {
//			boardVO.setBid(bid);
//			boardVO.setBcategory("11111111111111111111111111111111111111111111111111111111");
//			boardDAO.updateBoard(boardVO);
//		}catch(RuntimeException e) {
//			throw new CommonExceptionAdvice();
//		}
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
}
