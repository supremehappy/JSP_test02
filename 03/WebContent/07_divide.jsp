<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--JSP 페이지에서 에러가 발생하였을 때 보여줄 에러 페이지로 error.jsp를 설정 --%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
0으로 나누는 것은 불능입니다.
<%--강제로 예외를 발생시킴 --%>
<%= 2/0 %>
</body>
</html>