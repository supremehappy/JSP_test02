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

<jsp:useBean id="member" class="com.test.six.MemberBean"/>
<jsp:setProperty property="*" name="member"/>

<h2>정보 처리 페이지</h2>
<table>
		<tr>
			<td>name 	</td>
			<td><jsp:getProperty name="member" property="name"/></td>
		</tr>
		<tr>
			<td>id 	</td>
			<td><jsp:getProperty name="member" property="userid"/></td>
		</tr>
		<tr>
			<td>nickname 	</td>
			<td><jsp:getProperty name="member" property="nickname"/></td>
		</tr>
		<tr>
			<td>password 	</td>
			<td><jsp:getProperty name="member" property="pw"/></td>
		</tr>
		<tr>
			<td>email 	</td>
			<td><jsp:getProperty name="member" property="email"/></td>
		</tr>
		<tr>
			<td>phone 	</td>
			<td><jsp:getProperty name="member" property="phone"/></td>
		</tr>
	</table>
</body>
</html>