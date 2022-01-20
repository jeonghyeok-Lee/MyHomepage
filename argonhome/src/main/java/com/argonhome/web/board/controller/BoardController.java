package com.argonhome.web.board.controller;

import javax.inject.Inject;

import com.argonhome.web.board.service.BoardService;
import com.argonhome.web.board.model.BoardVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// RequestMapping(value ="") 어노테이션을 통해서 주소를 조합할 수 있다.
// 현재 아래 어노테이션까지는 주소:포트번호/web/board를 말하는 것
@RequestMapping(value = "/board")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	// 이곳을 지나면서 주소:포트/web/board/getBoardList가 된다.
	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	public String getBoardList(Model model) throws Exception{
		model.addAttribute("boardList",boardService.getBoardList());
		return "board/index";
	}
}
/*
 * 전체적인 흐름을 보면 
 * 웹 주소창에 주소:포트/web/board/getBoardList를 입력시(즉. 메뉴에서 게시판이름 클릭시) !-- 서버->모듈->/web을 /으로 변경하여 /web을 작성안해도됨
 * Controller에서 해당 주소를 결합하여 getBoardList메소드를 실행						--> Controller는 전달받은 데이터를 boardList라는 이름으로 화면에 전달 이때 화면의 이름은 return값인 "board/index"
 * Controller의 getBoardList메소드에서는 Service의 getBoardList()를 호출				--> Service는 BoardVO타입의 데이터를 Controller에 전달
 * Service에서는 DAO의 getBoardList()를 호출하는 것									--> DAO의 getBoardList()는 db에서 리스트를 조회, BoardVO타입으로 Service에 반환
 * */
