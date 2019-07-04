	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<%@include file="../include/header.jsp"%>
	<section class="content">
		<!-- 회원가입 form : 유효성 검사를 위해서 id를 부여
		enctype은 file을 전송할 때 사용
		최근에는 form의 전송방식은 거post
		조회할 때 입력받는 부분만 get -->
		<form id="registerform" enctype="multipart/form-data" method="post">
			<p align="center">
			<table border="1" width="50%" height="80%" align='center'>
				<tr>
					<td colspan="3" align="center"><h2>회원 가입</h2></td>
				</tr>
				<tr>
				<!-- rowspan은 행을 합치는 것 -->
					<td rowspan="5" align="center">
						<p></p> 
						<img id="img" width="100" height="100" border="1" /> <br />
						<br />
						<!-- accept 속성은 파일 선택을 제한 : 확장자를 가지고 제한 -->
						 <input type='file' id="image" name="image"
						accept=".jpg,.jpeg,.gif,.png" /><br />
					</td>
				</tr>

				<tr>
					<td bgcolor="#f5f5f5">
					<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;이메일</font>
					</td>
					<td>&nbsp;&nbsp;&nbsp; 
					<!-- HTML5에서 input의 type을  추가된 형태를 설정하면
					형식 검사도 수행해 줍니다.
					name은 서버에게 전달할 이름이고 id는 스크립트가 사용할 이름 
					2개를 동일하게 설정하는 것이 코딩할 때 수월합니다. -->
					<input type="email" name="email"
						id="email" size="30" maxlength=50 required="required" />
						<div id="emaildiv"></div>
					</td>
				</tr>
				<tr>
					<td bgcolor="#f5f5f5">
					<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호</font>
					</td>
					<td>&nbsp;&nbsp;&nbsp; 
					<input type="password" name="pw" id="pw" 
					size="20"  maxlength="15" required="required" />
					</td>
				</tr>

				<tr>
					<td bgcolor="#f5f5f5">
					<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호 확인</font></td>
					<td>&nbsp;&nbsp;&nbsp; 
					<input type="password" id="pwconfirm"
						size="20" required="required" />
					</td>
				</tr>
				<tr>
					<td width="17%" bgcolor="#f5f5f5">
					<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;닉네임</font>
					</td>
					<td>&nbsp;&nbsp;&nbsp;
					<!-- pattern은 정규식 패턴을 설정해서 유효성 검사 수행
					title은 유효성 검사에 실패했을 때 보여지는 텍스트 인데 브라우저에 잘 적용이 안됨  -->
					 <input type="text" name="nickname"
						id="nickname" size="20" pattern="([a-z, A-Z, 가-힣]){2,}"
						required="required" title="닉네임은 문자 2자 이상입니다." />
						<div id="nicknamediv"></div>
						
					</td>
				</tr>

				<tr>
					<td align="center" colspan="3">
						<p></p> 
						<!-- 부트스트랩에서는 버튼 class를 적용하면 색상이 변경됩니다  -->
						<input type="submit" value="회원가입" class="btn btn-warning" />
						<!-- 인라인 이벤트 처리 방식으로  클릭이벤트 처리 
						간단한 구문에는 유용하지만 태그 안에 스크립트코드가 있어서 가독성이 떨어지기 때문에 최근에는 비추천 -->
						<input type="button" value="메인으로" 
						class="btn btn-success"
						onclick="javascript:window.location='/'">
						<p></p>
					</td>
				</tr>
			</table>
		</form>
		<br /> <br />
	</section>
	<%@include file="../include/footer.jsp"%>
	
	<script>
	 document.getElementById("image").addEventListener(
	 "change", function(e){
		//파일 선택 여부 확인 
		//프로그래밍 언어 들 중에는 데이터가 없으면 false를 리턴하기도 합니다.
		if(this.files && this.files[0]){
			//파일의 내용을 읽는 객체를 생성
			var reader = new FileReader();
			//파일을 읽는 것은 비동기적으로 동작 -  CallBack 함수가 필요합니다.
			reader.readAsDataURL(this.files[0])
			//파일을 읽는 동작이 종료되면 처리
			reader.addEventListener("load", function(e){
				//읽은 내용을 img 태그에 출력
			document.getElementById("img").src = e.target.result;
			});
		}
	 });
	 
	 //이메일 중복검사 여부를 통과했는지를 저장할 변수를 생성 
	 var emailcheck = false;
	 //email 입력 란에서 포커스가 떠나면
	 document.getElementById("email").addEventListener(
			 "focusout", function(e){
		 var email = document.getElementById("email").value;
		 if(email.trim().length > 0){
			 $.ajax({
				 url:'emailcheck',
			 data:{
				 'email':email
			 },
			 dataType: 'json',
			 success:function(data){
				 var emaildiv = document.getElementById("emaildiv")
				 if(data.result == true){
					 emaildiv.innerHTML = '사용 가능한 이메일 입니다.'
					 emaildiv.style.color = 'green'
					 emailcheck = true
				 }else{
					 emaildiv.innerHTML = '사용  불가능한 이메일 입니다.'
						 emaildiv.style.color = 'red'
						 emailcheck = false
				 }
				 
			 }
			 
			 })
		 }
	 });
	 
	 //닉네임 중복체크 여부를 저장할 변수를 선언
	 var nicknamecheck = false;
	 
	 
	 var nickname = document.getElementById("nickname");
	 var nicknamediv = document.getElementById("nicknamediv");
	 
	 nickname.addEventListener("focusout", function(e){
		$.ajax({
			url:"nicknamecheck",
			data:{
				"nickname":nickname.value
			},
			dataType:'json',
			success:function(data){
				
			if(data.result == true){
				nicknamediv.innerHTML = '사용 가능한 닉네임 입니다.'
					 nicknamediv.style.color = 'green'
					 nicknamecheck = true
			}else{
				nicknamediv.innerHTML = '사용  불가능한 닉네임 입니다.'
					nicknamediv.style.color = 'red'
						nicknamecheck = false
			}
				
		}
		});
	 });
	 
	 //registrform에 submit 이벤트가 발생했을 때 처리
	 document.getElementById("registerform").addEventListener(
			 "submit", function(e){ 
				 if(emailcheck == false){
					 document.getElementById("emaildiv").innerHTML = "이메일 중복 검사를 통과하지 못했습니다.";
					 document.getElementById("emaildiv").style.color = 'red';
					 document.getElementById("email").focus();
					 e.preventDefault();
					 return;
				 }
				 
				 if(nicknamecheck == false){
					 document.getElementById("nicknamediv").innerHTML = "닉네임 중복 검사를 통과하지 못했습니다.";
					 document.getElementById("nicknamediv").style.color = 'red';
					 document.getElementById("nickname").focus();
					 e.preventDefault();
					 return;
				 }
				 
				 //비밀번호와 비밀번호 확인을 가져오기
				 var pw = document.getElementById("pw")
				 var pwconfirm = document.getElementById("pwconfirm")
				 //==는 값만비교하는 경우이고 ===는 값과 자료형 모두 비교
				 //가끔 1 == '1' ?
				 if(pw.value != pwconfirm.value){
					 alert("비밀번호와 비밀번호 확인의 값은 같아야 합니다.")
					 pw.focus();
					 e.preventDefault();
					 return;
				 }
				 
				 //숫자, 소문자, 대문자, 특수문자의 정규식 패턴
				 var p1 = /[0-9]/;
				 var p2 = /[a-z]/;
				 var p3 = /[A-Z]/;
				 var p4 = /[!@#$%^&*()]/;
				 //pw에 위 4개의 패턴이 등장하지 않거나 8자보다 글자수가 작으면 전송하지 않음
				 if(!p1.test(pw.value) || !p2.test(pw.value) || !p3.test(pw.value) || !p4.test(pw.value) || pw.value.length < 8){
					 alert("비밀번호는 8자 이상이고 숫자, 영어 대소문자 그리고 특수문자가 1개 이상이어야 합니다.");
					 e.preventDefault();
					 pw.focus();
					 return;
				 }

			 })
	 
	 
	</script>
	
	
	
