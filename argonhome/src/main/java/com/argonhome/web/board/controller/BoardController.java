package com.argonhome.web.board.controller;

import javax.inject.Inject;

import com.argonhome.web.board.service.BoardService;
import com.argonhome.web.board.model.BoardVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	// 글쓰기 버튼클릭시 
	@RequestMapping("/boardForm")
	public String boardForm(@ModelAttribute("boardVO") BoardVO vo, Model model) {
		return "board/BoardForm";
	}
	
	/*
	 * @ModelAttribute("BoardVO") BoardVO boardVO - 해당인자는 화면에서 넘겨주는 값을 BoardVO와 매칭하여 데이터를 가져오게됨
	 * RedirectAttributes rttr - 해당인자는 글쓰기를 작성이후 돌아가야할 페이지에 데이터를 전달하기 위한 인자
	 * 			+ 브라우저의 뒤로가기 버튼의 대응책 => 글쓰기 화면 -> 저장 단계(서버) -> 리스트 화면 순서인데 뒤로가기로 가면 저장단계를 계속 중복으로 가게됨 해당인자사용시 글쓰기화면으로 이동함
	 * */
	@RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
	public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO, @RequestParam("mode") String mode, RedirectAttributes rttr) throws Exception{
		// 수정되었다면
		if (mode.equals("edit")) {
			boardService.updateBoard(boardVO);
		} else {
			boardService.insertBoard(boardVO);
		}
		// 돌아갈 페이지 주소를 지정
		return "redirecet:/board/getBoardList";
	}
	
	@RequestMapping(value = "/getBoardContent", method= RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("bid") int bid) throws Exception{
		model.addAttribute("boardContent",boardService.getBoardContent(bid));
		return "board/boardContent";
	}
	
	@RequestMapping(value = "/editForm", method = RequestMethod.GET)
	public String editForm(@RequestParam("bid") int bid, @RequestParam("mode") String mode, Model model) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
		model.addAttribute("mode", mode);
		model.addAttribute("boardVO", new BoardVO());	//!! 추가 폼과 연계하기 위함
		return "board/boardForm";
	}
	
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
	public String deleteBoard(RedirectAttributes rttr, @RequestParam("bid") int bid) throws Exception {
		boardService.deleteBoard(bid);
		return "redirect:/board/getBoardList";
	}
}
/*
 * 전체적인 흐름을 보면 
 * 웹 주소창에 주소:포트/web/board/getBoardList를 입력시(즉. 메뉴에서 게시판이름 클릭시) !-- 서버->모듈->/web을 /으로 변경하여 /web을 작성안해도됨
 * Controller에서 해당 주소를 결합하여 getBoardList메소드를 실행						--> Controller는 전달받은 데이터를 boardList라는 이름으로 화면에 전달 이때 화면의 이름은 return값인 "board/index"
 * Controller의 getBoardList메소드에서는 Service의 getBoardList()를 호출				--> Service는 BoardVO타입의 데이터를 Controller에 전달
 * Service에서는 DAO의 getBoardList()를 호출하는 것									--> DAO의 getBoardList()는 db에서 리스트를 조회, BoardVO타입으로 Service에 반환
 * */
