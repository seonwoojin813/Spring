<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- spring의 태그 라이브러리를 사용하기 위한 설정 -->
    <%@ taglib prefix="spring"
    uri="http://www.springframework.org/tags" %>
    
    <!-- spring의 form 태그를 사용하기 위한 라이브러리 설정 -->
    <%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- properties 파일에 있는 login.form.title 메시지 출력 -->
<title><spring:message code="login.form.title" /></title>
</head>
<body>
    <form:form modelAttribute="member">
    <p>
       <label for="email"><spring:message code="email" text="디폴트 이메일"/></label>
      <!-- path를 설정하면 id와 name이 자동 설정
      modelAttribute에서 설정된 객체의 내용이 Value로 설정됩니다. -->
       <form:input path ="email" />
       </p>
       <p>
         <label for="password"><spring:message code="password" /></label>
       <form:password path = "pw" />
       </p>
       
       <p>
       <form:select path ="loginType" items="${loginTypes}"/>
       </p> 

       <input type="submit" value="<spring:message code="login.form.login"/>" />
    </form:form>
</body>
</html>