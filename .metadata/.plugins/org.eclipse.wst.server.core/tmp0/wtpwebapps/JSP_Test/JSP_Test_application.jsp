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
	String app = application.getContextPath();
	String file  = application.getRealPath("JSP_Test_application.jsp");
%>
컨택스트 패스명 <br>
<b><%=app %></b><hr>
웹 어플 패스명 <br>
<b><%=file %></b><hr>
</body>
</html>