<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id="test";
	String pw="1234";
	String name="ex";
	
	request.setCharacterEncoding("UTF-8");
	
	if(id.equals(request.getParameter("id"))&&pw.equals(request.getParameter("pw"))){
		response.sendRedirect("JSP_Test_main.jsp?name="+URLEncoder.encode(name,"UTF-8"));
	}else{
		response.sendRedirect("JSP_Test_loginForm.jsp");
	}
%>
</body>
</html>