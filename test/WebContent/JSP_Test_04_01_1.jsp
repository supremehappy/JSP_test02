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
	String search = request.getParameter("search");
	response.setContentType("text/html;charset=UTF-8");

	if(search.equals("naver")){
		response.sendRedirect("http://www.naver.com");
	}else if(search.equals("daum")){
		response.sendRedirect("http://www.daum.net");
	}else if(search.equals("google")){
		response.sendRedirect("http://www.google.com");
	}else{
		out.print("sorry");
	}
%>
</body>
</html>