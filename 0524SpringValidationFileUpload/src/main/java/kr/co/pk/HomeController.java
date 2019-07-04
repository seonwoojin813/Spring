package kr.co.pk;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.pk.domain.Member;
import kr.co.pk.domain.User;
import kr.co.pk.validator.UserValidator;

@Controller
public class HomeController {
	//이 어노테이션이 사용되면 모든 뷰 페이지에게 데이터가 전달됩니다.
	@ModelAttribute("loginTypes")
	public List<String> loginType(){
		List<String> list = new ArrayList<String>();
		list.add("개인회원");
		list.add("기업회원");
		list.add("학생회원");
		
		return list;
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		return "home";
	}
	
	@RequestMapping(value = "messagedisplay", method = RequestMethod.GET)
	//ModelAttribute 안에 있는 member는 msgdisp에서 사용할 Command 이름
	//매개변수는 member는 메소드 안에서 사용할 이름
	public String messageDisplay( Model model, 
	@ModelAttribute("member") Member member) {
		return "msgdisp";
    }
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	//유효성 검사를 수행해야하는 페이질로 이동하는 경우에는 
	//@ModelAttribute로 매개변수를 추가해서 입력한 내용을 돌려 받을 수 있도록 해주어야합니다.
	//이부분 중요해 기억해
	public String login( 
			Model model, @ModelAttribute("user") User user) {
		return "login";
	}	
	
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	//유효성 검사를 할 때는 유효성 검사 결과를 저장할 BindingResult 변수를 매개변수로 추가해야합니다.
	public String loginProcess( 
			Model model,  User user, BindingResult result) {
		//유효성검사를 수행하고 결과를 result에 저장
		new UserValidator().validate(user, result);
		//유효성 검사에 실패했을 때
		if(result.hasErrors()) {
			return "login";
		}
		
		return "redirect:./";
	}	
	
	
}
