<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>myHome</title>
</head>
<body>
<h2 align="center">어서오세요.</h2>
<table border="1" cellpadding="10">
	<tr>
		<td width="190" valign="top">
			
			<c:choose>
				<c:when test="${sessionScope.id ==null }">
					<jsp:include page="login.jsp" />
				</c:when>
				<c:otherwise>
					<jsp:include page="logout.jsp" />
				</c:otherwise>
			</c:choose>
			
			<a href="templat.jsp?BODY=intro.html">소개</a><br>
			<a href="templat.jsp?BODY=bbsInput.html">게시판 글쓰기</a><br>
			<a href="bbs-list">게시판 읽기</a><br>
			<a href="templat.jsp?BODY=productInput.html">상품 등록</a><br>
			<a href="pro-list">상품 목록</a><br>
			<a href="">장바구니</a><br>
		</td>
		<td width="650" valign="top">
			<c:choose>
				<c:when test="${param.BODY !=null }">
					<jsp:include page="${param.BODY}"/>
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