<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="now" value="<%=new java.util.Date() %>"/>
<pre>
톰캣 서버 로케일 : <%=response.getLocale() %>

<fmt:setLocale value="ko_kr"/>
로케일 한국어로 설정 : <%=response.getLocale() %>
통화 :  <fmt:formatNumber value="10000" type="currency"/>
날짜 :  <fmt:formatDate value="${now }"/>

<fmt:setLocale value="ja_JP"/>
로케일 일어로 설정 : <%=response.getLocale() %>
통화 :  <fmt:formatNumber value="10000" type="currency"/>
날짜 :  <fmt:formatDate value="${now }"/>

<fmt:setLocale value="en_US"/>
로케일 영어로 설정 : <%=response.getLocale() %>
통화 :  <fmt:formatNumber value="10000" type="currency"/>
날짜 :  <fmt:formatDate value="${now }"/>
</pre>
</body>
</html>