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
<c:if test="${ empty writing }">
	존재하지 않는 게시글입니다.
</c:if>
<c:if test="${ ! empty writing }">
<table width="100%" border="1">
	<tr><td>글제목</td><td>${writing.title }</td></tr>
	<tr><td>작성자</td><td>${writing.writer_name }</td></tr>
	<tr><td colspan="2" align="center"><img alt="" width="350"
	height="300" border="0"	src="uploadfiles/${writing.image_name}">
	</td></tr>
	<tr><td>글내용</td><td>${writing.content }</td></tr>
	<tr><td colspan="2">
		<a href="javascript:goReply()">[답글]</a>
		<a href="javascript:goModify()">[수정]</a>
		<a href="javascript:goDelete()">[삭제]</a>
		<a href="image-list">[목록]</a>
	</td></tr>
</table>
</c:if>

<script type="text/javascript">
	function goReply(){
		document.move.action="write-form";
		document.move.submit();
	}
	
	function goModify(){
		document.move.action="image-update";
		document.move.submit();
	}
	
	function goDelete(){
		document.move.action="image-delete";
		document.move.submit();
	}
</script>

<form name="move" method="post">
	<input type="hidden" name="id" value="${writing.writing_id }"/>
	<input type="hidden" name="parentid" value="${writing.writing_id }"/>
	<input type="hidden" name="groupid" value="${writing.group_id }"/>
</form>

</body>
</html>