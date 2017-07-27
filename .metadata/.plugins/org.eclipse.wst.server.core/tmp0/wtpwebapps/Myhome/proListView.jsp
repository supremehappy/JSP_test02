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
<h1 align="center">목록</h1>
<table border="1">
	<tr>
		<td width="40">글번호</td>
		<td width="100">상품명</td>
		<td width="60">가격</td>
		<td width="80">작성자</td>
		<td width="90">작성일</td>
	</tr>
	<c:forEach var="cnt" begin="0" end="${PRO_LIST.listSize-1 }">
		<tr>
			<td>${PRO_LIST.proList[cnt] }</td>
			<td><a href="proitem?PID=${PRO_LIST.proList[cnt] }">${PRO_LIST.nameList[cnt] }</td>
			<td>${PRO_LIST.priceList[cnt] }</td>
			<td>${PRO_LIST.writerList[cnt] }</td>
			<td>${PRO_LIST.dateList[cnt] }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>