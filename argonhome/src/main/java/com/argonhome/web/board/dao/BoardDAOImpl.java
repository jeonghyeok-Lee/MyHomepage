package com.argonhome.web.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.argonhome.web.board.model.BoardVO;
import com.argonhome.web.common.Pagination;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;	// �ش� ��ü�� ���� boardMapper�� �ۼ��� ���� sql�� ���� ����
	
	@Override
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.argonhome.web.board.boardMapper.getBoardList", pagination);
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
		return sqlSession.update("com.argonhome.web.board.boardMapper.updateBoard",boardVO);
	}

	@Override
	public int deleteBoard(int bid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.argonhome.web.board.boardMapper.deleteBoard",bid);
	}

	@Override
	public int updateViewCnt(int bid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("com.argonhome.web.board.boardMapper.updateViewCnt",bid);
	}

	@Override
	public int getBoardListCnt() throws Exception {
		return sqlSession.selectOne("com.argonhome.web.board.boardMapper.getBoardListCnt");
	}

}
