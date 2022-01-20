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
			logger.info("�����Ͱ� �����ϴ�.");
		}
	}
	
	// Ignore-> �ش� �޼ҵ带 �����Ű�� �ʴ� ���
	@Test 
	public void testGetBoardContent() throws Exception {
		BoardVO boardVO = boardDAO.getBoardContent(1);
		logger.info("\n Board List \n ");
		if(boardVO != null) {
			logger.info("�۹�ȣ : " + boardVO.getBid() );
			logger.info("������ : " + boardVO.getBtitle() );
			logger.info("�۳��� : " + boardVO.getBcontext() );
			logger.info("���±� : " + boardVO.getBtag() );
			logger.info("��ȸ�� : " + boardVO.getBview_cnt() );
			logger.info("�ۼ��� : " + boardVO.getBwriter() );
			logger.info("�ۼ��� : " + boardVO.getBwrite_dy() );
			logger.info("������ : " + boardVO.getBedit_dy() );
		} else {
			logger.info("�����Ͱ� �����ϴ�.");
		}
	}
	
	@Test @Ignore 
	public void testInsertBoard() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBcategory("1");
		boardVO.setBtitle("ù��° �Խù�");
		boardVO.setBcontext("ù��° �Խù��Դϴ�.");
		boardVO.setBtag("1");
		boardVO.setBwriter("1");

		int result = boardDAO.insertBoard(boardVO);
		logger.info("\n Insert Board Result " +result);
		if(result == 1) {
			logger.info("\n �Խù� ��� ���� ");
		} else {
			logger.info("\n �Խù� ��� ����");
		}
	}

	@Test @Ignore 
	public void testUpdateBoard() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setBid(1);
		boardVO.setBcategory("1");
		boardVO.setBtitle("������ ù��° �Խù�.");
		boardVO.setBcontext("������ ù��° �Խù��Դϴ�.");
		boardVO.setBtag("1-1");

		int result = boardDAO.updateBoard(boardVO);
		logger.info("\n Update Board Result \n ");
		if(result > 0) {
			logger.info("\n �Խù� ���� ���� ");
		} else {
			logger.info("\n �Խù� ���� ����");
		}
	}
	
	@Test   @Ignore
	public void tesDeleteBoard() throws Exception {
		int result = boardDAO.deleteBoard(1);
		logger.info("\n Delete Board Result \n ");
		if(result > 0) {
			logger.info("\n �Խù� ���� ���� ");
		} else {
			logger.info("\n �Խù� ���� ����");
		}
	}

	@Test @Ignore
	public void testUpdateViewCnt() throws Exception {
		int result = boardDAO.updateViewCnt(1);
		logger.info("\n Update View Count Result \n ");
		if(result > 0) {
			logger.info("\n �Խù� ��ȸ�� ������Ʈ ���� ");
		} else {
			logger.info("\n �Խù� ��ȸ�� ������Ʈ ����");
		}
	}
	

}
