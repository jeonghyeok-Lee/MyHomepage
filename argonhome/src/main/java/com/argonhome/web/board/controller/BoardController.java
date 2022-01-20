package com.argonhome.web.board.controller;

import javax.inject.Inject;

import com.argonhome.web.board.service.BoardService;
import com.argonhome.web.board.model.BoardVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// RequestMapping(value ="") ������̼��� ���ؼ� �ּҸ� ������ �� �ִ�.
// ���� �Ʒ� ������̼Ǳ����� �ּ�:��Ʈ��ȣ/web/board�� ���ϴ� ��
@RequestMapping(value = "/board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	// �̰��� �����鼭 �ּ�:��Ʈ/web/board/getBoardList�� �ȴ�.
	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	public String getBoardList(Model model) throws Exception{
		model.addAttribute("boardList",boardService.getBoardList());
		return "board/index";
	}
}
/*
 * ��ü���� �帧�� ���� 
 * �� �ּ�â�� �ּ�:��Ʈ/web/board/getBoardList�� �Է½�(��. �޴����� �Խ����̸� Ŭ����) !-- ����->���->/web�� /���� �����Ͽ� /web�� �ۼ����ص���
 * Controller���� �ش� �ּҸ� �����Ͽ� getBoardList�޼ҵ带 ����						--> Controller�� ���޹��� �����͸� boardList��� �̸����� ȭ�鿡 ���� �̶� ȭ���� �̸��� return���� "board/index"
 * Controller�� getBoardList�޼ҵ忡���� Service�� getBoardList()�� ȣ��				--> Service�� BoardVOŸ���� �����͸� Controller�� ����
 * Service������ DAO�� getBoardList()�� ȣ���ϴ� ��									--> DAO�� getBoardList()�� db���� ����Ʈ�� ��ȸ, BoardVOŸ������ Service�� ��ȯ
 * */
