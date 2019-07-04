<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link rel="stylesheet" href="./resources/css/chat.css" />
</head>
<body>	
	<fieldset>
		<legend>Chating Area</legend>
		Nickname : <input type="text" id="nickname" />
		<input type="button" id="enterbtn" value="Enter" />
		<input type="button" id="exitbtn" value="Exit" />
		
		<h3>Message Area</h3>
		<!-- 스크롤 바를 배치하기 위해서 div 안에서 div 배치 -->
		<div id="chatArea">
			<div id="chatMessageArea"></div>
		</div>
		<br />
		<input type="text" id="message" size="50" />
		<input type="button" id="sendBtn" value="Send" />
	</fieldset>

	<script>
		//웹 소켓 변수
		var wsocket;

		//웹 소켓에 연결하고 이벤트 처리 함수를 지정하는 함수
		function connect() {
			//웹 소켓을 생성해서 연결
			wsocket = new WebSocket("ws://localhost:8080/pk/chat-ws")
			//이벤트 핸들러 연결
			wsocket.addEventListener("open", function(e) {
				//메시지 출력 함수 호출
				appendMessage("Connected Success")
			});

			wsocket.addEventListener("close", function(e) {
				appendMessage("DisConnected")
			});
			wsocket.addEventListener("message", function(e) {
				appendMessage(e.data)
			});

			//나가기 버튼을 클릭했을 때 이벤트 처리
			document.getElementById("exitbtn").addEventListener("click",
					function(e) {
						wsocket.close();
					});
			//전송버튼을 누르면 입력한 내용을 보내기
			document.getElementById("sendBtn").addEventListener("click",
					function(e) {
						//입력한 내용 가져오기
						var str = document.getElementById("message").value
						var nick = document.getElementById("nickname").value
						//메시지 전송
						wsocket.send(nick + ":" + str)
						document.getElementById("message").value = ""
					});
		}
		//메시지를 입력하다가 Enter를 누르면 메시지를 전송
		document.getElementById("message").addEventListener("keypress",
				function(e) {
					var keycode = e.keyCode ? e.keyCode : e.which
					if (keycode == 13) {
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

		function appendMessage(msg) {
			document.getElementById("chatMessageArea").innerHTML = msg
					+ "<br />"
					+ document.getElementById("chatMessageArea").innerHTML
		}
		//입장 버튼을 눌렀을 때 connect 함수를 호출하도록 설정
		document.getElementById("enterbtn").addEventListener("click",
				function(e) {
					connect();
				});

		document.getElementById("sendbtn").addEventListener(
				"click",
				function(e) {
					//웹 소켓에 연결
					var websocket = new WebSocket(
							"ws://localhost:8080/pk/echo-ws")
					//웹 소켓에 연결되면 메시지를 전송
					websocket.addEventListener("open", function(e) {
						//입력한 메시지 전송
						websocket.send(document.getElementById("msg").value)
					});

					//웹 소켓이 닫힐 때 호출될 로직
					websocket.addEventListener("close", function(e) {
						//입력한 메시지 전송
						alert("웹 소켓 연결 종료")
						return

						

					});

					//서버에서 메시지가 왔을 때 호출될 로직
					websocket.addEventListener("message", function(e) {
						//입력한 메시지 전송
						alert(e.data)
						//웹 소켓 연결 해제
						websocket.close()
					});

				});
	</script>

</body>
</html>