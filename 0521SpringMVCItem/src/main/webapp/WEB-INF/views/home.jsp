<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 반복문이나 조건문을 사용해야 할 때 사용할 JSTL 태그 라이브러리 호출 -->
    <%@  taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록 화면</title>
<link rel="stylesheet" href="css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
  window.onload = function(){
	  var ajax = document.getElementById("ajax");
	  var disp = document.getElementById("disp");
	  
	  ajax.addEventListener("click", function(e){
		  $.ajax({
			  url:'controller.json',
		      data:{  },
		      dataType:'json',
		      success:function(data){
		    		  $.each(data.data, function(){
		    			 disp.innerHTML += this 	    		 
						});
				}
			})
	  })
	}
</script>

</head>
<body>
<!--  ${list} -->
<!--<c:forEach var="item" items="${list}" >
${item.itemid}<br />
</c:forEach>
-->

<p><a href="filelist.do">파일 목록 보기</a></p>

<!--  <h3 align="center"><a href="excel.xlsx">엑셀 만들기</a></h3> -->
<p><a href="excel.xlsx">엑셀 만들기</a></p>

<p><a href="data.pdf">PDF 만들기</a></p>

<p><a href="view.json">View를 이용한 JSON 만들기</a></p>

<p><a href="data.csv">csv 출력</a></p>

<!-- <p><a href="controller.json">Controller를 이용한 JSON 만들기 </a></p> -->

 <p><a href="#" id="ajax">Controller를 이용한 JSON 만들기 </a></p> 
 
 <p><a href="data.xml">xml 출력</a></p>
 
  <p><a href="exception.do">예외처리</a></p>
 
<div id="disp"></div>

<div align="center" class="body">
<h3>상품 목록 확인</h3>
<table border="1">
<tr class="header">
<th width="80">상품ID</th>
<th width="300">제품명</th>
<th width="100">가격</th>
</tr>

<c:forEach var="item" items="${list}" >
<tr class="record">
<td align="center">${item.itemid}</td>

<!--  <td>&nbsp;<a href="detail?itemid=${itemid}">
${item.itemname}
</a>
</td>-->

<td>&nbsp;
<a href="detail/${item.itemid}">${item.itemname}
</a>
</td>
					<td align="right">${item.price}원&nbsp;</td>
		</tr>
			</c:forEach>
</table>
</div>
</body>
</html>