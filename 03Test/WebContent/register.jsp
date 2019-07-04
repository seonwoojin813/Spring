<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%
   db.Dao dao = new db.Dao();
    int seq = dao.getSequence();
    java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
    String date = today.toString();
    date = date.replace("-", "");
    
    db.Member member = new db.Member();
    member.setCustno(seq);
    member.setCustname("손흥민");
    member.setPhone("01077777777");
    member.setAddress("토트넘");
    member.setGrade("A");
    member.setJoindate(today);
    member.setCity("UK");
    
    dao.insert(member);
   %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <input type="text" value=<%=seq %> /><br />
    <input type="text" value=<%=date %> /><br />

</body>
</html>