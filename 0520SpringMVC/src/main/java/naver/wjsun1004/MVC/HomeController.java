package naver.wjsun1004.MVC;

import java.text.DateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//Controller(클라이언트의 요청을 처리하는 객체) 클래스로 만들고
//객체 생성을 자동으로 해주는 annotation
@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// /요청이 GET 방식으로 왔을 때 처리하는 메소드
	//디렉토리 패턴을 사용할 때는 디렉토리 부분을 제외학 value에 설정
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*
		logger.info("Welcome home! The client locale is {}.", locale);	
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);		
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );
		*/
		return "home";
	}
	
	//get.do 요청이 GET 방식으로 오는 경우 처리하는 메소드
	@RequestMapping(value="get.do", method=RequestMethod.GET)
	//public void get(HttpServletRequest request) {   --- 밑에 처럼 쓰기 위해 주석처리
	public void get(
			@RequestParam("num") int num,
			@RequestParam("name") String name) {
		
		/*
		위에 처럼 쓰면
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		*/
		
		
		//num과 name 파라미터 값을 읽어서 콘솔에 출력
		//형변환은 자동
		/*
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		*/
		System.out.println(num + ":" + name);
	}
	
	//post.do 요청을 POST 방식으로 전송한 경우 처리하는 메소드
	@RequestMapping(value="post.do", method=RequestMethod.POST)
	//public void post(HttpServletRequest request) {   --- 밑에 처럼 쓰기 위해 주석처리
	public void post(@RequestParam("name") String name,
			@RequestParam("hobby") ArrayList<String> hobbies)  {
        /* 
		위에 처럼 쓰면 밑에 이부분
		String name = request.getParameter("name");
	    체크박스나 select는 배열로 받아서 저장
		String []  hobbies = request.getParameterValues("hobby"); 지워도됨
		 */
		
	    //num과 name 파라미터 값을 읽어서 콘솔에 출력
		
		//파라미터가 인코딩 처리 - 여기서 처리하면 처리할 때 마다 아래코드를 작성 - 100개 쓰면 100번 써야하는 번거로움
		//필터를 이용해서 요청이 올 때 마다 필터에서 인코딩 처리를 하도록 설정 
		/*
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		//이렇게 하면 2가지 문제가 발생
		//post 방식은 한글 인코딩 처리를 안하면 깨짐
		//두개 체크 하면 하나만 나와
		/*
		 String name = request.getParameter("name");
		 String hobby = request.getParameter("hobby");
		System.out.println(num + ":" + hobby);
	}
		*/
		
		//그래서 밑에 처럼
		//String name = request.getParameter("name");
		
		//체크박스나 select는 배열로 받아서 저장
		//String []  hobbies = request.getParameterValues("hobby");
		System.out.println("name:" + name );
		for(String hobby : hobbies) {
			System.out.print(hobby + "\t");
		}
	}
	
	@RequestMapping(value="ajax.do", method=RequestMethod.GET)
	//public void ajax(HttpServletRequest request) {
	public void ajax(Command command) {
	//Command라는 클래스를 만들고 getter & setter 하고 toString 한다음에 위에 주석처리 하고 Command command 해주고
	//밑에 부분 주석처리
		
		//num과 name 파라미터 값을 읽어서 콘솔에 출력
		/*
		String num = request.getParameter("num");
		String name = request.getParameter("name");		
		System.out.println(num + ":" + name);		
		*/
		System.out.println(command);
	}
	@RequestMapping(value="forward.do", method=RequestMethod.GET)
	public String forward(Model model) {
		//결과 페이지를 전달할 데이터
		model.addAttribute("msg", "포워딩에 전달할 데이터");		
		//결과 페이지 이름 설정 : 앞에 redirect: 가 없으므로 포워딩
		return "result";
	}
	
	@RequestMapping(value="redirect.do", method=RequestMethod.GET)
	//RedirectAttributes 는 redirect할 때 데이터를 전달하기 위한 클래스
	public String redirect(RedirectAttributes attr) {
		//결과 페이지를 전달할 데이터
		attr.addFlashAttribute("msg", "리다이렉트에 전달할 데이터");		
		//결과 페이지 이름 설정 : 앞에 redirect: 가 없으므로 포워딩
		return "redirect:display.do";
	}
	
	@RequestMapping(value="display.do", method=RequestMethod.GET)
	//RedirectAttributes 는 redirect할 때 데이터를 전달하기 위한 클래스
	public String display(RedirectAttributes attr) {
		//결과 페이지 이름 설정 : 앞에 redirect: 가 없으므로 포워딩
		return "display";
	}
	
	//json 출력
	@RequestMapping(value="json.do", method=RequestMethod.GET)
	public @ResponseBody Command json() {
		Command command = new Command();
		command.setNum(1);
		command.setName("한지민");
		return command;
		//이걸로는 팅겨서 pom.xml에 써줘야해
		/*
		 <!-- json 출력을 위한 라이브러리 -->
         <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-databind</artifactId> 
         <version>2.9.4</version>
	      </dependency>		 
		 */
		 
	}
}
