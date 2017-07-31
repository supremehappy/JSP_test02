<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">목록</h1>
page : ${PRO_LIST.pageNum }
<table border="1">
	<tr>
		<td width="40">글번호</td>
		<td width="100">상품명</td>
		<td width="80">가격</td>
		<td width="100">작성자</td>
		<td width="100">작성일</td>
		<td width="100">&nbsp;</td>
	</tr>
	<c:forEach var="cnt" begin="0" end="${PRO_LIST.listSize-1 }">
		<tr>
			<td>${PRO_LIST.proList[cnt] }</td>
			<td><a href="proitem?PID=${PRO_LIST.proList[cnt] }">${PRO_LIST.nameList[cnt] }</td>
			<td><fmt:formatNumber groupingUsed="true">${PRO_LIST.priceList[cnt] }</fmt:formatNumber> 원</td>
			<td>${PRO_LIST.writerList[cnt] }</td>
			<td>${PRO_LIST.dateList[cnt] }</td>
			<td><a href="#" onClick="window.open('add-cart?CODE=${PRO_LIST.proList[cnt] }','Cart_Result','width=400,height=150').focus()">장바구니 담기</a></td>
		</tr>
	</c:forEach>
</table>

<c:if test="${!PRO_LIST.firstPage }">
	<a href="pro-list?FIRST_PID=${PRO_LIST.proList[0] }">previous page</a>
</c:if>

<c:forEach var = "page" begin="1" end="${PRO_LIST.pageNum }">
	<a href="pro-list?PAGE_NO=${page }">${page}</a>
</c:forEach>

<c:if test="${!PRO_LIST.lastPage }">
	<a href="pro-list?LAST_PID=${PRO_LIST.proList[PRO_LIST.listSize-1] }">next page</a>
</c:if>
</body>
</html>