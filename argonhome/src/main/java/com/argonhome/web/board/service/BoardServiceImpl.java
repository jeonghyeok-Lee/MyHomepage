package com.argonhome.web.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.argonhome.web.board.dao.BoardDAO;
import com.argonhome.web.board.model.BoardVO;

// service�� controller�� ��û�� ���� �ʿ��� ����Ͻ� ������ ó��. �ʿ��Ѱ�� db���� ó���� ����
@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> getBoardList() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList();
	}
	
	@Override
	public void insertBoard(BoardVO boardVO) throws Exception{
		boardDAO.insertBoard(boardVO);
	}

}
