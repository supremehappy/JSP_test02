<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4 align="center">장바구니 관리</h4>
<c:choose>
	<c:when test="${CART_LIST.itemSize == 0 || CART_LIST == null}">
		<h3 align="center">장바구니가 비었습니다.</h3>
	</c:when>
	<c:otherwise>
		<table border="1">
			<tr>
				<td width="70">상품번호</td>
				<td width="250">상품이름</td>
				<td width="80">상품가격</td>
				<td width="50">상품갯수</td>
				<td width="80">수정/삭제</td>
			</tr>
			<c:forEach var="cnt" begin="0" end="${CART_LIST.itemSize -1 }">
			<form action="modify-cart" method="post">
			<input type="hidden" name="CODE" value="${CART_LIST.codeList[cnt] }"/>
			<tr>
				<td>${CART_LIST.codeList[cnt] }</td>
				<td>${CART_LIST.nameList[cnt] }</td>
				<td>${CART_LIST.priceList[cnt] }</td>
				<td><input type="text" size="3" name="NUMBER"
				value="${CART_LIST.numList[cnt] }"/></td>
				<td><input type="submit" value="수정" name="BTN"/>
				<input type="submit" value="삭제" name="BTN"/></td>
			</tr>
			</form>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
</body>
</html>












