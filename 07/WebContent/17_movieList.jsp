<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="cnt" begin="1" end="10" varStatus="status">
	${cnt }<c:if test="${not status.last}">,</c:if>
</c:forEach>
<br><br>
<table border="1" style="width:100%; text-align:center;">
	<tr>
		<td>index</td><td>count</td><td>cnt</td>
	</tr>
	<c:forEach var="cnt" begin="7" end="10" varStatus="status">
		<tr>
			<td>${status.index}</td>
			<td>${status.count}</td>
			<td>${cnt}</td>
		</tr>
	</c:forEach>
</table>
<br><br>
<table border="1" style="width:100%; text-align:center;">
	<tr>
		<td>index</td><td>count</td><td>cnt</td>
	</tr>
	<c:forEach var="cnt" begin="1" end="10" varStatus="status" step="2">
		<tr>
			<td>${status.index}</td>
			<td>${status.count}</td>
			<td>${cnt}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>

