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
<jsp:useBean id="item" class="com.test.two.itemBean"/>
<jsp:setProperty property="*" name="item"/>

<h3>입련된 정보</h3>
<table>
		<tr>
			<td>상품명		</td>
			<td><jsp:getProperty name="item" property="name"/></td>
		</tr>
		<tr>
			<td>가격		</td>
			<td><jsp:getProperty name="item" property="price"/></td>
		</tr>
		<tr>
			<td>설명		</td>
			<td><jsp:getProperty name="item" property="description"/></td>
		</tr>
	</table>
</body>
</html>