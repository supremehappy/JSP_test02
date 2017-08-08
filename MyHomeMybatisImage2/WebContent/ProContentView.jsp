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

<c:if test="${ empty pro }">
	존재하지 않는 게시글입니다.
</c:if>
<c:if test="${ ! empty pro }">
<table width="100%" border="1">
	<tr>
		<td>상품명</td>
		<td>${pro.name }</td>
	</tr>
	<tr>
		<td>가 격</td>
		<td>${pro.price }</td>
	</tr>
	<tr>
		<td>글내용</td>
		<td>${pro.content }</td>
	</tr>
	<tr><td colspan="2">
		<a href="javascript:goReply()">[답글]</a>
		<a href="javascript:goModify()">[수정]</a>
		<a href="javascript:goDelete()">[삭제]</a>
		<a href="pro-list">[목록]</a>
	</td></tr>
</table>
</c:if>

<script type="text/javascript">
	function goReply(){
		document.move.action="pro-form";
		document.move.submit();
	}
	
	function goModify(){
		document.move.action="pro-update";
		document.move.submit();
	}
	
	function goDelete(){
		document.move.action="pro-delete";
		document.move.submit();
	}
</script>

<form name="move" method="post">
	<input type="hidden" name="pid" value="${pro.pid }"/>
	<input type="hidden" name="parentid" value="${pro.pid }"/>
	<input type="hidden" name="groupid" value="${pro.group_id }"/>
</form>

</body>
</html>