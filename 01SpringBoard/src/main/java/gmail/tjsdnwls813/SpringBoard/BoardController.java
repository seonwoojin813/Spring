package gmail.tjsdnwls813.SpringBoard;

//import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gmail.tjsdnwls813.SpringBoard.domain.Board;
import gmail.tjsdnwls813.SpringBoard.domain.Criteria;
import gmail.tjsdnwls813.SpringBoard.domain.SearchCriteria;
import gmail.tjsdnwls813.SpringBoard.service.BoardService;

@Controller
//모든 요청 처리 메소드의 value 앞에 이 내용이 추가
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String register(Model model) {
		return "board/register";
	}
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String register(Model model,
			HttpServletRequest request,
			RedirectAttributes attr) {
		int result = boardService.register(request);
		if(result > 0) {
			//게시글 쓰기에 성공할 경우
			attr.addFlashAttribute("msg","게시글이 성공적으로 작성되었습니다.");
			return "redirect:list";			
		}else {
			attr.addFlashAttribute("msg","게시글이 작성에 실패했습니다.");
			return "redirect:register";
		}
	}
	
	/*
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) {
		List<Board> list = boardService.list();
		model.addAttribute("list", list);
		return "board/list";
	}
	*/
	
	/*
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Criteria criteria, Model model) {
		Map<String, Object> map = boardService.list(criteria);
		model.addAttribute("map", map);
		return "board/list";
	}
	*/
	

	@RequestMapping(value="list", method=RequestMethod.GET)
	//@ModelAttribute("cri") SearchCriteria
	//파라미터를 criteria로 받아서 사용하고
	//결과 페이지에 cri라는 이름으로 넘겨주는 설정
	public String list(@ModelAttribute("cri") SearchCriteria criteria, Model model) {
		Map<String, Object> map = boardService.list(criteria);
		model.addAttribute("map", map);
		return "board/list";
	}
	
	@RequestMapping(value="detail/{bno}", method=RequestMethod.GET)
	public String detail(
			@PathVariable("bno") int bno,
			Model model) {
		Board board = boardService.detail(bno);
		model.addAttribute("vo", board);
		
		return "board/detail";
	}
  
	@RequestMapping(value="update/{bno}", method=RequestMethod.GET)
	public String update(
			@PathVariable("bno") int bno,
			Model model) {
		Board board = boardService.updateView(bno);
		model.addAttribute("vo",board);
		return "board/update";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Board board, Model model, 
			RedirectAttributes attr) {
		int result = boardService.update(board);
		if(result > 0) {
			attr.addFlashAttribute("msg", "수정성공");
			return "redirect:/board/list";
			
		}else {
			return "redirect:/board/update";
		}
	}
	
	@RequestMapping(value="delete/{bno}", method=RequestMethod.GET)
	public String delete(@PathVariable("bno") int bno, Model model, 
			RedirectAttributes attr) {
		int result = boardService.delete(bno);
		if(result > 0) {
			attr.addFlashAttribute("msg", "삭제성공");
			return "redirect:/board/list";
			
		}else {
			return "redirect:/board/delete";
		}
	}
			
}
