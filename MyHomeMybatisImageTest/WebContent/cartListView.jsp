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
<h4 align="center">��ٱ��� ����</h4>
<c:choose>
	<c:when test="${CART_LIST.itemSize == 0 || CART_LIST == null}">
		<h3 align="center">��ٱ��ϰ� ������ϴ�.</h3>
	</c:when>
	<c:otherwise>
		<table border="1">
			<tr>
				<td width="70">��ǰ��ȣ</td>
				<td width="250">��ǰ�̸�</td>
				<td width="80">��ǰ����</td>
				<td width="50">��ǰ����</td>
				<td width="80">����/����</td>
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
				<td><input type="submit" value="����" name="BTN"/>
				<input type="submit" value="����" name="BTN"/></td>
			</tr>
			</form>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
</body>
</html>











