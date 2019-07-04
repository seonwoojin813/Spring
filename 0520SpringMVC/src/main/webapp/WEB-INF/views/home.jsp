<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>

<!-- webapp/js/jquery.js 파일의 링크 설정
모든 링크 설정은  파일의 위치가 아니고 URL 기준
webapp이 루트  -->
<script src = "js/jquery.js"></script>
<script>
	//body 위에 써야 할때는 읽고나서 행동해야 하므로
	window.onload = function(){	
	}
</script>
</head>
<body>
    <a href="get.do?num=1&name=sun">get 방식</a><br />
    <form action="post.do" method="post">
    <label for="name">이름</label>
    <input type="text" name="name" id="name" /><br />
    
    <label for="hobby">취미</label><br/>
    <input type="checkbox" name="hobby" value="exercise" /> 운동
    <input type="checkbox" name="hobby" value="game" /> 게임
    <input type="checkbox" name="hobby" value="music" /> 음악
    <input type="checkbox" name="hobby" value="movie" /> 영화
     <br />
     <input type="submit" />    
    </form>
    
    <br />
    <input type="button" value="ajax 요청"
    id = "ajaxbtn" />
    
    <a href="forward.do">포워딩</a><br />
    <a href="redirect.do">리다이렉트</a><br />
    <a href="json.do">json출력</a><br />
    
    <script>
    document.getElementById("ajaxbtn").addEventListener('click', function(e){
    	$.ajax(
    	{
    		url:'ajax.do',
    		data:{'num':'1', 'name':'한지민'},
    		success:function(data){
    			alert('ajax 요청 성공')
    		}
    	}		
    	);
    });
    </script>
    
</body>
</html>