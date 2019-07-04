package kr.co.pk.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.pk.domain.User;

public class UserValidator implements Validator {

	//유효성 검사를 수행할 클래스를 설정하는 메소드
	@Override
	public boolean supports(Class<?> clazz) {
		//User 클래스에대한 유효성 검사를 수행하겠다는 설정
		return User.class.isAssignableFrom(clazz);
	}
   //유효성 검사를 수행할 메소드
	//target이 위에서 설정한 클래스의 객체입니다.
	//강제 형 변환해서 사용
	//errors는 유효성 검사에 실패했을 때 출력할 메시지를 설정하는 객체
	@Override
	public void validate(Object target, Errors errors) {
		User user =(User)target;
		if(user.getId() == null  || user.getId().trim().length() == 0) {
			//메시지 파일에 required.id 라는 메시지가 존재해야 합니다.
			errors.rejectValue("id", "required");
		}
		if(user.getPw() == null  || user.getPw().trim().length() == 0) {
			//메시지 파일에 required.Pw 라는 메시지가 존재해야 합니다.
			errors.rejectValue("pw", "required");
		}
		
	}

}
