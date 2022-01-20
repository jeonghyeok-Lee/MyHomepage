package com.argonhome.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.argonhome.web.board.dao.BoardDAO;
import com.argonhome.web.board.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:springsources/root-context.xml",
		"classpath:springsources/dataSource-context.xml",
		"classpath:servlet-context.xml"
		})

public class BoardDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Inject
	private BoardDAO boardDAO;
	
	@Test  @Ignore
	public void testGetBoardList() throws Exception {
		List<BoardVO> boardList = boardDAO.getBoardList();
		logger.info("\n Board List \n ");
		if(boardList.size() > 0) {
			for(BoardVO list : boardList) {
				logger.info(list.getBtitle());
			}
		} else {
			logger.info("데이터가 없습니다.");
		}
	}
	
	// Ignore-> 해당 메소드를 실행시키지 않는 기능
	@Test 
	public void testGetBoardContent() throws Exception {
		BoardVO boardVO = boardDAO.getBoardContent(1);
		logger.info("\n Board List \n ");
		if(boardVO != null) {
			logger.info("글번호 : " + boardVO.getBid() );
			logger.info("글제목 : " + boardVO.getBtitle() );
			logger.info("글내용 : " + boardVO.getBcontext() );
			logger.info("글태그 : " + boardVO.getBtag() );
			logger.info("조회수 : " + boardVO.getBview_cnt() );
			logger.info("작성자 : " + boardVO.getBwriter() );
			logger.info("작성일 : " + boardVO.getBwrite_dy() );
			logger.info("수정일 : " + boardVO.getBedit_dy() );
		} else {
			logger.info("데이터가 없습니다.");
		}
	}
	
	@Test @Ignore 
	public void testInsertBoard() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBcategory("1");
		boardVO.setBtitle("첫번째 게시물");
		boardVO.setBcontext("첫번째 게시물입니다.");
		boardVO.setBtag("1");
		boardVO.setBwriter("1");

		int result = boardDAO.insertBoard(boardVO);
		logger.info("\n Insert Board Result " +result);
		if(result == 1) {
			logger.info("\n 게시물 등록 성공 ");
		} else {
			logger.info("\n 게시물 등록 실패");
		}
	}

	@Test @Ignore 
	public void testUpdateBoard() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBid(1);
		boardVO.setBcategory("1");
		boardVO.setBtitle("수정된 첫번째 게시물.");
		boardVO.setBcontext("수정된 첫번째 게시물입니다.");
		boardVO.setBtag("1-1");

		int result = boardDAO.updateBoard(boardVO);
		logger.info("\n Update Board Result \n ");
		if(result > 0) {
			logger.info("\n 게시물 수정 성공 ");
		} else {
			logger.info("\n 게시물 수정 실패");
		}
	}
	
	@Test   @Ignore
	public void tesDeleteBoard() throws Exception {
		int result = boardDAO.deleteBoard(1);
		logger.info("\n Delete Board Result \n ");
		if(result > 0) {
			logger.info("\n 게시물 삭제 성공 ");
		} else {
			logger.info("\n 게시물 삭제 실패");
		}
	}

	@Test @Ignore
	public void testUpdateViewCnt() throws Exception {
		int result = boardDAO.updateViewCnt(1);
		logger.info("\n Update View Count Result \n ");
		if(result > 0) {
			logger.info("\n 게시물 조회수 업데이트 성공 ");
		} else {
			logger.info("\n 게시물 조회수 업데이트 실패");
		}
	}
	

}
