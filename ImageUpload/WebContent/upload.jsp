<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UploadServlet" method="post" enctype="multipart/form-data">
글쓴이 : <input type="text" name="NAME"/><br> 
제목 : <input type="text" name="TITLE"/><br>
파일선택 : <input type="file" name="FILE_NAME"/><br>
<input type="submit" value="전송">
</form>
</body>
</html>