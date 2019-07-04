package kr.co.validation.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.validation.domain.Member;

public class MemberValidator implements Validator {

	//유효성 검사를 수행할 클래스를 설정하는 메소드
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Member.class.isAssignableFrom(clazz);
	}

	//실제 유효성 검사를 수행할 메소드
	@Override
	public void validate(Object target, Errors errors) {
		//매개변수로 전달 된 target을 유효성 검사를 수행할 객체로 변환
		Member member = (Member) target;
		
		//id에 대한 유효성 검사
	    ValidationUtils.rejectIfEmptyOrWhitespace(
	    		errors, "id", "required.id");
		//pw에 대한 유효성 검사
	    ValidationUtils.rejectIfEmptyOrWhitespace(
	    		errors, "pw", "required.pw");
		if(member.getPw().trim().length() < 8 || member.getPw().trim().length() > 15) {
			errors.rejectValue("pw", "length");
		}
	    
		//nickname에 대한 유효성 검사
	    ValidationUtils.rejectIfEmptyOrWhitespace(
	    		errors, "nickname", "required.nickname");
	    
	    /*
		if(member.getId().trim().length() < 1) {
			//에러메시지 만들기
			//메시지에 requierd.id 또는 required라는 이름이 존재해야 합니다.
			errors.rejectValue("id", "required");
		}

		// pw에 대한 유효성 검사
		if (member.getPw().trim().length() < 1) {
			// 에러메시지 만들기
			// 메시지에 requierd.id 또는 required라는 이름이 존재해야 합니다.
			errors.rejectValue("pw", "required");
		}
		
		if(member.getPw().trim().length() < 8 || member.getPw().trim().length() > 15) {
			errors.rejectValue("pw", "length");
		}
		// nickname에 대한 유효성 검사
		if (member.getNickname().trim().length() < 1) {
			// 에러메시지 만들기
			// 메시지에 requierd.id 또는 required라는 이름이 존재해야 합니다.
			errors.rejectValue("nickname", "required");
		}
		*/

	}

}
