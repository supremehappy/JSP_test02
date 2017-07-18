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
	response.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="movie" class="com.test.three.MovieBean"></jsp:useBean>
<jsp:setProperty property="*" name="movie"/>

<table>
		<tr>
			<td>제목 		</td>
			<td><jsp:getProperty name="movie" property="title" /></td>
		</tr>
		<tr>
			<td>가격 		</td>
			<td><jsp:getProperty name="movie" property="price" /></td>
		</tr>
		<tr>
			<td>감독 		</td>
			<td><jsp:getProperty name="movie" property="director" /></td>
		</tr>
		<tr>
			<td>출연배우 		</td>
			<td><jsp:getProperty name="movie" property="actor" /></td>
		</tr>
		<tr>
			<td>시놉시스 		</td>
			<td><jsp:getProperty name="movie" property="synopsis" /></td>
		</tr>
		<tr>
			<td>장르 		</td>
			<td><jsp:getProperty name="movie" property="genre" /></td>
		</tr>
	</table>
</body>
</html>