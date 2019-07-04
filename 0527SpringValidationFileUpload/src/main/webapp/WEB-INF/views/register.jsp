<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- spring 의 custom tab을 이용하기 위한 라이브러리 설정
    custom tag: 제공되는 것이 아닌 직접 생성한 태그 -->
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<!-- Controller가 넘겨준 member라는 Command 객체를 form에 매핑 -->
<form:form method="post" modelAttribute="member">

<label for="id">아이디</label>
<!-- HTML5를 이용해서 입력 유효성을 검사를 할 때는 
required, pattern, minlength, maxlength등을 이용 -->

<form:input  path="id" />
<form:errors path="id" />
<br />

<label for="pw">비밀번호</label>
<form:password path="pw"  />
<form:errors path="pw" />
<br />

<label for="name">이름</label>
<form:input path="name" /><br />

<label for="nickame">nickname</label>
<form:input path="nickname" />
<form:errors path="nickname" />
<br />

<label for="mobile">모바일</label>
<form:input path="mobile" /><br />

  <input type="submit" value="회원가입" />
  <input type="button" value="메인으로" />
</form:form>


<!-- <script>
    //이벤트 처리
    document.getElementById("member").addEventListener(
    		"submit", function(e){
    			//focus 옮기는거 
    			//document.getElementById("nickname").focus();
    			
    			//id라는 id를 DOM(문서의 일부분이 되는 객체) 객체 가져오기
    			var ids = document.getElementById("id")
    			//좌우 공백을 제거하고 길이가 1보다 작으면 전송하지 않고 메시지를 출력한 후 
    			//포커스를 그 자리로 옮겨줍니다.
    			if(id.value.trim().length < 1){
    			  alert("아이디는 필수 입력입니다.")
    			  ids.focus()
    			//기본 이벤트 취소
    		e.preventDefault();
    			  return
    		}
    			
    			//pw라는 id를 DOM(문서의 일부분이 되는 객체) 객체 가져오기
    			var pw = document.getElementById("pw")
    			//좌우 공백을 제거하고 길이가 1보다 작으면 전송하지 않고 메시지를 출력한 후 
    			//포커스를 그 자리로 옮겨줍니다.
    			if(pw.value.trim().length < 1){
    			  alert("비밀번호는 필수 입력입니다.")
    			  pw.focus()
    			//기본 이벤트 취소
    		e.preventDefault();
    			  return   			  
    		}
    			//정규식 객체를 생성
    			//정규식은 ""이게 없음
    			var pwReg = /^[a-zA-Z0-9]{8,15}$/
    			//정규식 검사
    			if(pwReg.test(pw.value) == false){
    				alert("비밀번호는 영문 또는 숫자 8-15자리입니다.")
    				pw.focus()
    				//기본이벤트 취소
    				e.preventDefault();
      			  return  
    			}
    			
    			//nickname라는 id를 DOM(문서의 일부분이 되는 객체) 객체 가져오기
    			var nickname = document.getElementById("nickname")
    			//좌우 공백을 제거하고 길이가 1보다 작으면 전송하지 않고 메시지를 출력한 후 
    			//포커스를 그 자리로 옮겨줍니다.
    			if(nickname.value.trim().length < 1){
    			  alert("닉네임은 필수 입력입니다.")
    			  nickname.focus()
    			//기본 이벤트 취소
    		e.preventDefault();
    			  return
    		}

    		});
    
</script>-->

</body>
</html>