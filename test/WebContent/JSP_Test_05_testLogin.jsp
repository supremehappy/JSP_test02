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
	String id = "test";
	String pw = "1234";
	String name="ex";
	
	if(id.equals(request.getParameter("id"))&&pw.equals(request.getParameter("pw"))){
		Cookie c = new Cookie(id,name);
		//클라이언트 전송 부분 구현	
		response.addCookie(c);
%>
<h2>login success</h2>
<p><a href="JSP_Test_05_main.jsp">join</a></p>
<%
	}else{
%>
<h2>login fail</h2>
<p><a href="JSP_Test_05_loginForm.jsp">join</a></p>
<%
	}
%>
</body>
</html>