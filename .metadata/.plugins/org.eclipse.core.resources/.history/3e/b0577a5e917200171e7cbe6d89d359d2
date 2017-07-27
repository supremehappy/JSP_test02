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
	<c:when test="${param.UPLOAD != null }">
		<h2>plz, login</h2>
		<form action="login" method="post">
			아디 : <input type="text" name="id" size="12" /><br>
			비번 : <input type="password" name="pw" size="12" /><br>
			<input type="submit" value="send"/>
		</form>
	</c:when>
	
	<c:otherwise>
		<form action="login" method="post">
			아디 : <input type="text" name="id" size="12" /><br>
			비번 : <input type="password" name="pw" size="12" /><br>
			<input type="submit" value="send"/>
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>
