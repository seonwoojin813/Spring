<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- 스프링의 태그를 사용하기 위한 라이브러리 설정 -->  
  <%@ taglib prefix="spring" 
  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form:form modelAttribute="user">
           아이디:<form:input path="id" />
		<br />
		<form:errors path="id" />
		<br />
           비밀번호:<form:password path="pw" />
		<br />
		<form:errors path="pw" />
		<br />
		<input type="submit" value="로그인" />
	</form:form>
</body>
<script>
//입력오류가 발생했을 때 수행할 내용
</script>
</html>