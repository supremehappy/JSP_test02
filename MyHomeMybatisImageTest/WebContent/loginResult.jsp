<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${param.RESULT == 'OK'}">
		<h3 align="center">�α��εǾ����ϴ�.</h3>
		<h3 align="center">ȯ���մϴ�. ${sessionScope.ID }��~</h3>
	</c:when>
	<c:otherwise>
		<h3 align="center">�α��ε��� ���߽��ϴ�.</h3>
		<h3 align="center">���̵�� �н����带 Ȯ���ϼ���.</h3>
	</c:otherwise>
</c:choose>
</body>
</html>





