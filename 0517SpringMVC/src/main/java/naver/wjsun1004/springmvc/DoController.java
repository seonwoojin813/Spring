package naver.wjsun1004.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DoController {
   @RequestMapping("/hello.do")
   public ModelAndView hello() {
	   ModelAndView mav = new ModelAndView();
	   mav.setViewName("hello");
	   mav.addObject("attr", "data");
	   return mav;
   }
	// Get 방식의 process.do 요청을 처리하는 메소드
	@RequestMapping(value="process.do", method=RequestMethod.GET)
	public ModelAndView processGet() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("process");
		return mav;
	}
	// Post 방식의 process.do 요청을 처리하는 메소드
	@RequestMapping(value="process.do", method=RequestMethod.POST)
	public ModelAndView processPost() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}

   //blog 디렉토리 패턴에서 blog/article/110을 처리하는 메소드
   @RequestMapping("/article/{num}")
   public ModelAndView article(@PathVariable int num) {
	   System.out.println(num);
	   System.out.println("멍충하지만 착한 친구");
		   ModelAndView mav = new ModelAndView();
		   mav.setViewName("process");
		   return mav;
	   }
   
}
