<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
<form method="post" enctype="multipart/form-data">
<label for="name">이름</label>
<input type="text" name="name" id="name" /><br />
<label for="imgfile">이미지 파일</label>
<input type="file" name="imgfile" id="imgfile" accept=".jpg, .jpeg, .gif, .png" /><br />
<input type="submit" value="제출" />
</form>
</body>
</html>