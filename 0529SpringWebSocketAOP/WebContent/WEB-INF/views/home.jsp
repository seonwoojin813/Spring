<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<link rel="stylesheet" href="./resources/css/chat.css">
</head>
<body>

	<fieldset align="center">
		<legend>Echo</legend>
		Message : <input  type="text" id="msg" />
		<input type="button" id="sendbtn" value="Send"/>
	</fieldset>
	
	<c:if test="${user == null}">
	<a href="login">로그인</a><br/>
	</c:if>
	<c:if test="${user != null}">
	${user.nickname}님 환영합니다.<br />
	<a href="logout">로그아웃</a><br/>
	</c:if>
	<a href="arrayinsert">ArrayList Insert</a><br/>
	<a href="linkedinsert">LinkedList Insert</a><br/>
	<a href="arrayread">ArrayList Read</a><br/>
	<a href="arrayread">ArrayList Read</a><br/>

	<a href="chat">채팅 페이지</a><br />
	
	<script>
		//웹 소켓 변수
		var wsocket;
		
		//웹 소켓에 연결하고 이벤트 처리 함수를 지정하는 함수
		function connect(){
			//웹 소켓을 생성해서 연결
			wsocket = new WebSocket(
				"ws://localhost:8080/pk/chat-ws")
			//웹 소켓 이벤트 핸들러 연결
			wsocket.addEventListener("open", function(e){
				//메시지 출력 함수 호출
				appendMessage("연결 성공");
			});
			wsocket.addEventListener("close", function(e){
				appendMessage("연결 해제");
			});
			wsocket.addEventListener("message", function(e){
				appendMessage(e.data)
			})
			
			//나가기 버튼을 클릭했을 때 이벤트 처리
			document.getElementById("exitBtn").addEventListener(
					"click", function(e){
				wsocket.close();
			});
			//전송버튼을 누르면 입력한 내용을 보내기
			document.getElementById("sendBtn").addEventListener(
					"click", function(e){
				//입력한 내용 가져오기
				var str = document.getElementById("message").value
				var nick = document.getElementById("nickname").value
				//메시지 전송
				wsocket.send(nick + ":" + str)
				document.getElementById("message").value = ""
			});
			
			//메시지를 입력하다가 Enter를 누르면 메시지를 전송
			document.getElementById("message").addEventListener(
				"keypress", function(e){
					var keycode = e.keyCode ? e.keyCode : e.which
					if(keycode == 13){
						//입력한 내용 가져오기
						var str = document.getElementById("message").value
						var nick = document.getElementById("nickname").value
						//메시지 전송
						wsocket.send(nick + ":" + str)
						document.getElementById("message").value = ""
					}
					//이벤트 전파를 금지
					e.stopPropagation()
			});
		}
		
		//메시지 영역에 메시지를 출력해주는 함수
		function appendMessage(msg){
			document.getElementById("chatMessageArea").innerHTML = 
				msg + "<br />" + 
				document.getElementById("chatMessageArea").innerHTML
		}
		//입장 버튼을 눌렀을 때 connect 함수를 호출하도록 설정
		document.getElementById("enterBtn").addEventListener(
			"click", function(e){
			connect();
		});
	</script>
</body>
</html>