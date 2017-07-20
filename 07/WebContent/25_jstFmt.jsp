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
<jsp:useBean id="now" class="java.util.Date"/>
<pre>
	default : <c:out value="${now }"/>
	kor KST : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
	
	<fmt:timeZone value="GMT">
		swiss GMT : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
	</fmt:timeZone>
	
	<fmt:timeZone value="GMT-8">
		newyork GMT-8 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
	</fmt:timeZone>
</pre>
</body>
</html>