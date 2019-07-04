package kr.co.Login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.Login.domain.Member;
import kr.co.Login.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	MemberService memberService;
	
	//파라미터로 id와 pw를 전송하는 요청
	@RequestMapping("login")
	public Map<String, Object> login(Member member){
		Member result = memberService.login(member);
		Map<String, Object> map = new HashMap<String, Object>();
		//요청처리 메소드가 파라미터까지 왔는지 확인
				System.out.println(member);
		if(result != null) {
			map.put("result", "true");
		}else {
			map.put("result", "false");
		}
		return map;
	}

}
