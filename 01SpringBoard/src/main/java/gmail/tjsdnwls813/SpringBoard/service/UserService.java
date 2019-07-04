package gmail.tjsdnwls813.SpringBoard.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import gmail.tjsdnwls813.SpringBoard.domain.User;

public interface UserService {
    //email 중복체크 메소드
	public String emailcheck(String email);
	//nickname 중복체크 메소드
	public String nicknamecheck(String nickname);
	//파일업로드 처리를 Request를 이용하여 처리하기 위해서 파라미터를 
	//MultipartHttpServletRequest로 설정
	//파라미터 읽는 방법을 숙지
	public int register(MultipartHttpServletRequest request);
	//로그인 처리를 위한 메소드
	public User login(HttpServletRequest request);
	
	//위도와 경도 문자열을 받아서 주소를 리턴하는 메소드
	public String convertAddress(String param);
}
