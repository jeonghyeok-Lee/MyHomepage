package com.argonhome.web.board.dao;

import java.util.List;

import com.argonhome.web.board.model.BoardVO;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.argonhome.web.board.model.BoardVO;



public class BoardDAOImpl implements BoardDAO {
	
	private SqlSession sqlSession;	// �ش� ��ü�� ���� boardMapper�� �ۼ��� ���� sql�� ���� ����
	
	@Override
	public List<BoardVO> getBoardList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.argonhome.web.board.boardMapper.getBoardList");
	}

	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.argonhome.web.board.boardMapper.getBoardContent", bid);
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.argonhome.web.board.boardMapper.insertBoard",boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("com.argonhome.web.board.boardMapper.insertBoard",boardVO);
	}

	@Override
	public int deleteBoard(int bid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.argonhome.web.board.boardMapper.insertBoard",bid);
	}

	@Override
	public int updateViewCnt(int bid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("com.argonhome.web.board.boardMapper.updateViewCnt",bid);
	}

}