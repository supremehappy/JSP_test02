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
<h1 align="center">게시글 목록</h1>
<table border="1">
	<tr>
		<td width="40">글번호</td>
		<td width="300">글제목</td>
		<td width="80">작성자</td>
		<td width="90">작성일</td>
	</tr>
	<c:forEach var="cnt" begin="0" end="${BBS_LIST.listSize -1 }">
		<tr>
			<td>${BBS_LIST.seqNoList[cnt] }</td>
			<td><a href="bbsItem?SEQNO=${BBS_LIST.seqNoList[cnt] }">${BBS_LIST.titleList[cnt] }</a></td>
			<td>${BBS_LIST.writerList[cnt] }</td>
			<td>${BBS_LIST.dateList[cnt] }</td>
		</tr>
	</c:forEach>
</table>
<c:if test="${! BBS_LIST.firstPage}">
	<a href="bbs-list?FIRST_SEQNO=${BBS_LIST.seqNoList[0] }">이전 페이지</a>
</c:if>
<c:forEach var="page" begin="1" end="${BBS_LIST.pageNum}">
	<a href="bbs-list?PAGE_NO=${page }">${page }</a>
</c:forEach>
<c:if test="${! BBS_LIST.lastPage}">
	<a href="bbs-list?LAST_SEQNO=${BBS_LIST.seqNoList[BBS_LIST.listSize -1] }">다음 페이지</a>
</c:if>
</body>
</html>
































