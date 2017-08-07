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
<table width="100%">
	<tr>
		<td align="right"><b>${startRow }~${endRow }/${count }</b></td>
	</tr>
</table>

<table width="100%" border="1">
	<tr><td>이미지</td><td>글제목</td><td>작성자</td><td>작성일</td></tr>
	<c:if test="${ !empty LIST }">
	<c:forEach var="writing" items="${LIST }">
	<tr>
		<td><img src="uploadfiles/${writing.image_name }" 
		width="50" height="50"/></td>
		<td><a href="javascript:goView(${writing.writing_id })">${writing.title }</a></td>
		<td>${writing.writer_name }</td>
		<td>${writing.register_date }</td>
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
	document.sender.action="image-list";
	document.sender.page.value=pageNo;
	document.sender.submit();
}
function goView(id){
	if(id == null){
		alert("글번호가 없습니다.");
	}else{
		document.sender.id.value=id;
		document.sender.action="image-read";
		document.sender.submit();
	}
}
</script>
</body>
</html>









