<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ��</title>
</head>
<body>
<h2 align="center">�츮���� ���Ű��� ȯ���մϴ�.</h2>
<table border="1" cellpadding="10">
<tr>
	<td width="190" valign="top">
		<c:choose>
			<c:when test="${sessionScope.ID == null}">
				<jsp:include page="login.jsp"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="logout.jsp"/>
			</c:otherwise>
		</c:choose>
		<a href="template.jsp?BODY=intro.html">�츮�� �Ұ�</a><br/>
		<a href="template.jsp?BODY=bbsInput.jsp">�Խ��� �۾���</a><br/>
		<a href="bbs-list">�Խ��� ���б�</a><br/>
		<a href="">��ǰ ���</a><br/>
		<a href="product-list">��ǰ ���</a><br/>
		<a href="cart-list">��ٱ���</a><br/>
	</td>
	<td width="650" valign="top">
		<c:choose>
			<c:when test="${param.BODY != null }">
				<jsp:include page="${param.BODY }"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="front.jsp"/>
			</c:otherwise>
		</c:choose>
	</td>
</tr>
</table>
</body>
</html>



















