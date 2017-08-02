<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">상품 목록</h3>
<table border="1">
	<tr>
		<td width="40">상품번호</td>
		<td width="100">상품이름</td>
		<td width="80">상품가격</td>
		<td width="100">등록자</td>
		<td width="100">등록일</td>
		<td width="100">&nbsp;</td>
	</tr>
	<c:forEach var="cnt" begin="0" end="${PRODUCT_LIST.productSize -1 }">
	<tr>
		<td>${PRODUCT_LIST.pidList[cnt] }</td>
		<td>${PRODUCT_LIST.nameList[cnt] }</td>
		<td><fmt:formatNumber groupingUsed="true">
		${PRODUCT_LIST.priceList[cnt] }</fmt:formatNumber>원
		</td>
		<td>${PRODUCT_LIST.writerList[cnt] }</td>
		<td>${PRODUCT_LIST.dateList[cnt] }</td>
		<td><a href="#" onClick="window.open('add-cart?CODE=${PRODUCT_LIST.pidList[cnt] }','Cart_Result','width=400,height=150').focus()"
		>장바구니 담기</a></td>
	</tr>	
	</c:forEach>
</table>
</body>
</html>










