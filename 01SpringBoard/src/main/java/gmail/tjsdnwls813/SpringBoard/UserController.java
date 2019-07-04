package gmail.tjsdnwls813.SpringBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gmail.tjsdnwls813.SpringBoard.domain.User;
import gmail.tjsdnwls813.SpringBoard.service.UserService;

//Controller를 만들기 위한 어노테이션
@Controller
public class UserController {
	   @Autowired
	   private UserService userService;
	   
   @RequestMapping(
		   value="user/register", method=RequestMethod.GET)
   public String register (Model model){
	   
	   return "user/register";
   }
   

   
   //RedirextAttributes는 리다이렉트로 이동할 때 한번만 사용할 수 있는 데이터를
   //저장할 목적으로 만든 Spring의 클래스
   @RequestMapping(value="user/register", method=RequestMethod.POST)
   public String register (Model model,
		   MultipartHttpServletRequest request, 
		   RedirectAttributes attr) {
	   int result = userService.register(request);
	   if(result > 0) {
		   //성공했을 때 메시지를 저장
		   attr.addFlashAttribute("insert", "success");
		   return "redirect:/";
	   }else {
		   return "redirect:register";
	    }
     }
   
   //home.jsp 에서 login 요청을 했을 때 처리하는 메소드
   @RequestMapping(value="user/login", method=RequestMethod.GET)
   public String login (Model model) {
	   return "user/login";
   }
   
   @RequestMapping(value="user/login", method=RequestMethod.POST)
   public String login (HttpServletRequest request, 
		   HttpSession session, 
		   Model model,
		   RedirectAttributes attr) {
	   User user = userService.login(request);
	   //로그인 실패한 경우
	   if(user == null) {
	     attr.addFlashAttribute("msg", "없는 이메일이거나 잘못된 비밀번호입니다.")	;   
	   
	   return "redirect:login";
	   }else {
		   //로그인 성공했을 때는 로그인 정보를 세션에 저장
		   session.setAttribute("user", user);
	     //return "redirect:/";
		   //dest가 없으면 시작페이지로 있으면 그 페이지로 리다이렉트
		   if(session.getAttribute("dest") == null) {
			   return "redirect:/";
		   }else {
			   return "redirect:/" + 
		   session.getAttribute("dest").toString();
		   }
	   }
   }
   
   //home.jsp 에서 logout 요청을 했을 때 처리하는 메소드
   @RequestMapping(value="user/logout", 
		   method=RequestMethod.GET)
   public String logout (HttpSession session) {
	   //세션 초기화
	   session.invalidate(); //session.removeAttribute("user");
	   return "redirect:/";
   }
   
}
