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
<c:forEach var="pageNo" begin="1" end="${pageCount }">
	[${pageNo }]
</c:forEach>
<form method="post" name="sender">
	<input type="hidden" name="id"/>
</form>
<script type="text/javascript">
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









