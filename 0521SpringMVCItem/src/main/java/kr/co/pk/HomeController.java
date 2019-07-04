package kr.co.pk;


import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Date;
import java.util.List;
//import java.util.Locale;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.pk.domain.DataList;
import kr.co.pk.domain.DataModel;
import kr.co.pk.domain.Item;
import kr.co.pk.service.ItemService;
import kr.co.pk.service.ViewService;

@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ViewService viewService;
	
	//요청 처리 메소드를 만들 때 먼저 생각 : 요청주소 , 요청방식 파라미터
	@RequestMapping(value="filelist.do", method=RequestMethod.GET)
	public String filelist(Model model){
		//파일 목록 가져오기 서비스를 실행
		List<String>list = viewService.filelist();
		//데이터 저장하기
		model.addAttribute("list", list );
		
		return "filelist";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		//서비스의 메소드를 호출해서 결과를 조장
		List<Item> list = itemService.allItem();
		//결과 페이지에서 출력할 수 있도록 저장
		model.addAttribute("list", list);
		
		/*
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);		
		String formattedDate = dateFormat.format(date);		
		model.addAttribute("serverTime", formattedDate );
		*/
		return "home";
	}
	/*
	//요청은 detail이고 파라미터로 itemid를 받는요청을 처리하는 메소드
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(
			Model model,
			@RequestParam("itemid") int itemid) {
		//서비스 메소드 호출
		Item item = itemService.getItem(itemid);
		model.addAttribute("item", item);
		return "detail";
	}*/
	//요청은 detail/${itemid}를 받는요청을 처리하는 메소드
		@RequestMapping(value="detail/{itemid}", method=RequestMethod.GET)
		public String detaill(Model model,
				@PathVariable int itemid) {
		
			//서비스 메소드 호출
			Item item = itemService.getItem(itemid);
			model.addAttribute("item", item);
			return "detail";
}	
		

		//download.do?filename=${item} 요청을 처리하는 메소드
		@RequestMapping(value="download.do", method=RequestMethod.GET)
		public String download(Model model,
				@RequestParam("filename") String filename) {
		
			//파라미터를 이용해서 view에 전달할 데이터 만들기
			File f = new File(
					"/Users/a503_08/Downloads/" + filename);
			model.addAttribute("downloadFile", f);
			
		  //출력할 뷰 이름을 설정
			return "download";
}	
		
		
		@RequestMapping(value="excel.xlsx", method=RequestMethod.GET)
		public String excel(Model model) {
		//엑셀 파일에 출력할 데이터를 생성
			List<String>list = new ArrayList<>();
			list.add("레알마드리드");
			list.add("맨체스터유나이티드");
			list.add("유벤투스");
			
			//데이터를 전달하기 위해서 저장
			model.addAttribute("list", list);
		  
			return "excel";
		
		}
		
	@RequestMapping(value = "data.pdf", method = RequestMethod.GET)
	public String pdf(Model model) {

		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		map.put("OS", "Mac OS X");
		map.put("IDE", "STS");
		list.add(map);

		map = new HashMap<>();
		map.put("OS", "Window10");
		map.put("IDE", "Eclipse");
		list.add(map);

		// 데이터를 전달하기 위해서 저장
		model.addAttribute("list", list);

		return "pdf";
	}
	
	@RequestMapping(value="view.json", method=RequestMethod.GET)
	public String json(Model model) {
	
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		map.put("OS", "Mac OS X");
		map.put("IDE", "STS");
		list.add(map);

		map = new HashMap<>();
		map.put("OS", "Window10");
		map.put("IDE", "Eclipse");
		list.add(map);

		// 데이터를 전달하기 위해서 저장
		model.addAttribute("list", list);
		
		return "json";
	
	}
	@RequestMapping(value="data.xml", method=RequestMethod.GET)
	public String xml(Model model) {
	 DataModel model1 = new DataModel();
	 model1.setTitle("csv");
	 model1.setContent("구분자로 구분한 문자열");
	 
	 
	 DataModel model2 = new DataModel();
	 model2.setTitle("xml");
	 model2.setContent("태그를 이용한 방법");
	 
	 
	 DataModel model3 = new DataModel();
	 model3.setTitle("json");
	 model3.setContent("자바스크립트 문자열");
	 
	 List<DataModel> list = new ArrayList<>();
	 list.add(model1);
	 list.add(model2);
	 list.add(model3);
	 
	 
	 DataList dataList = new DataList();
	 dataList.setList(list);
	 
	 //데이터를 전달하기 위해서 저장
		model.addAttribute("list", dataList);
		return "xml";
	
	}
	
	@RequestMapping(value="exception.do", method=RequestMethod.GET)
	public String exception(Model model) {
		return "input";
	
	}
	@RequestMapping(value="exception.do", method=RequestMethod.POST)
	public String exception(Model model,
			@RequestParam("value1") int value1,
			@RequestParam("value2") int value2) {
		int result = value1/value2;
		model.addAttribute("result", result);
		return "result";
	
	}	
	
	//예외가 발생하면 error/error.jsp 퍄일을 출력해주는 설
	@ExceptionHandler(Exception.class)
public String exceptionHandling(Model model, Exception e) {
		model.addAttribute("ex", e.getMessage());
		return "error/error";
	}
		
}
