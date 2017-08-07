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
	<c:when test="${param.RESULT == 'OK'}">
		<h3 align="center">로그인되었습니다.</h3>
		<h3 align="center">환영합니다. ${sessionScope.ID }님~</h3>
	</c:when>
	<c:otherwise>
		<h3 align="center">로그인되지 못했습니다.</h3>
		<h3 align="center">아이디와 패스워드를 확인하세요.</h3>
	</c:otherwise>
</c:choose>
</body>
</html>






