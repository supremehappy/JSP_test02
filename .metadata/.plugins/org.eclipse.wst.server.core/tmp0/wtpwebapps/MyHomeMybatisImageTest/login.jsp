<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.UPLOAD != null }">
		<h2>���� �ø��÷���, �α����ؾ� �մϴ�.</h2>
		<form action="login" method="post">
		���̵� : <input type="text" name="ID" size="12"/><br/>
		�н����� : <input type="password" name="PWD" size="12"/><br/>
		<input type="submit" value="�α���"/>
		</form>
	</c:when>
	<c:otherwise>
		<form action="login" method="post">
		���̵� : <input type="text" name="ID" size="12"/><br/>
		�н����� : <input type="password" name="PWD" size="12"/><br/>
		<input type="submit" value="�α���"/>
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>










