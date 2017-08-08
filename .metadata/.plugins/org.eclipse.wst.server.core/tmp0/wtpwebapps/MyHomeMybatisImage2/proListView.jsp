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
<table width="100%">
	<tr>
		<td align="right"><b>${startRow }~${endRow }/${count }</b></td>
	</tr>
</table>

<table border="1">
	<tr>
		<td width="40">글번호</td>
		<td width="100">상품명</td>
		<td width="80">가격</td>
		<td width="100">작성자</td>
		<td width="100">작성일</td>
		<td width="100">&nbsp;</td>
	</tr>
		<c:if test="${ !empty LIST }">
	<c:forEach var="proitem" items="${LIST }">
	<tr>
		<td>${proitem.pid }</td>
		<td><a href="javascript:goView(${proitem.pid })">${proitem.name }</a></td>
		<td><fmt:formatNumber groupingUsed="true">${proitem.price }</fmt:formatNumber> 원</td>
		<td>${proitem.id }</td>
		<td>${proitem.p_date }</td>
		<td><a href="#" onClick="window.open('add-cart?CODE=${proitem.pid  }','Cart_Result','width=400,height=150').focus()">장바구니 담기</a></td>
	</tr>
	</c:forEach>
	</c:if>
</table>

<c:set var="startPage" value="${currentPage-(currentPage%10==0?10:(currentPage%10))+1 }"/>
<c:set var="endPage" value="${startPage+9 }"/>
<c:if test="${endPage > pageCount }">
	<c:set var="endPage" value="${pageCount }"/>
</c:if>
<c:if test="${startPage>10}">
	<a href="javascript:goPage(${startPage-10 })">[이전]</a>
</c:if>

<c:forEach var="pageNo" begin="${startPage }" end="${pageCount }">
	<c:if test="${currentPage ==pageNo}">
		<font size="5">
	</c:if>
	<a href="javascript:goPage(${pageNo })">[${pageNo }]</a>
	<c:if test="${currentPage ==pageNo}">
		</font>
	</c:if>
</c:forEach>

<c:if test="${endPage <pageCount }">
	<a href="javascript:goPage(${startPage+10 }">[다음]</a>
</c:if>

<form method="post" name="sender">
	<input type="hidden" name="id"/>
	<input type="hidden" name="page"/>
</form>

<script type="text/javascript">
function goPage(pageNo){
	document.sender.action="pro-list";
	document.sender.page.value=pageNo;
	document.sender.submit();
}
function goView(id){
	if(id == null){
		alert("글번호가 없습니다.");
	}else{
		document.sender.id.value=id;
		document.sender.action="proitem";
		document.sender.submit();
	}
}
</script>
</body>
</html>