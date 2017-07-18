<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="board" class="com.test.one.boardBean"/>
<jsp:setProperty property="*" name="board"/>

<h2>입력된 정보</h2>
<table>
		<tr>
			<td><label><b>작성자		</b></label></td>
			<td><jsp:getProperty name="board" property="name"/></td>
		</tr>
		<tr>
			<td><label><b>비번		</b></label></td>
			<td><jsp:getProperty name="board" property="pass"/></td>
		</tr>
		<tr>
			<td><label><b>이메일		</b></label></td>
			<td><jsp:getProperty name="board" property="email"/></td>
		</tr>
		<tr>
			<td><label><b>글제목		</b></label></td>
			<td><jsp:getProperty name="board" property="title"/></td>
		</tr>
		<tr>
			<td><label><b>글내용		</b></label></td>
			<td><jsp:getProperty name="board" property="content"/></td>
		</tr>
	</table>
</body>
</html>