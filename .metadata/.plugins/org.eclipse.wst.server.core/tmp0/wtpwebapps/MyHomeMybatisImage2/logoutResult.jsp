<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.RESULT == 'OK' }">
		<h1>로그아웃 되었습니다. 또 방문해 주세요~</h1>
	</c:when>
	<c:otherwise>
		<h1>로그아웃에 문제가 발생했습니다. 관리자에 문의해 주세요~</h1>
	</c:otherwise>
</c:choose>
</body>
</html>






