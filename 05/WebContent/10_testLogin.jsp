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
	String id="test";
	String pw= "1234";
	String name="ex";
	
	if(id.equals(request.getParameter("id"))&&pw.equals(request.getParameter("pw"))){
		session.setAttribute("loginUser", name);
		response.sendRedirect("10_main.jsp");
	}else{
		response.sendRedirect("10_loginForm.jsp");
	}
%>
</body>
</html>