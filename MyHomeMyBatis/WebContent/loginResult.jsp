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

	<c:when test="${param.RESULT=='ok'}">
		<h3 align="center">login success</h3>		
		<h3 align="center">hello, ${sessionScope.id}</h3>
	</c:when>

	<c:otherwise>
		<h3 align="center">login fail</h3>
		<h3 align="center">id, password</h3>
	</c:otherwise>

</c:choose>
</body>
</html>