<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>검색엔진</h2>
<h3>선택해</h3>
<form action="JSP_Test_04_01_1.jsp" method="post">
	<select id="search" name="search">
		<option value="">선택</option>
		<option value="naver">네이버</option>
		<option value="daum">다음</option>		
		<option value="google">구글</option>
	</select>
	<input type="submit" value="send"/>
</form>
</body>
</html>