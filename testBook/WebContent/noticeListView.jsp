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
	<c:forEach var="cnt" begin="0" end="${NOTICE_LIST.listSize -1 }">
		<tr>
			<td>${NOTICE_LIST.seqNoList[cnt] }</td>
			<td><a href="noticeItem?SEQNO=${NOTICE_LIST.seqNoList[cnt] }">${NOTICE_LIST.titleList[cnt] }</a></td>
			<td>${NOTICE_LIST.writerList[cnt] }</td>
			<td>${NOTICE_LIST.dateList[cnt] }</td>
		</tr>
	</c:forEach>
</table>
<c:if test="${! NOTICE_LIST.firstPage}">
	<a href="notice-list?FIRST_SEQNO=${NOTICE_LIST.seqNoList[0] }">이전 페이지</a>
</c:if>
<c:forEach var="page" begin="1" end="${NOTICE_LIST.pageNum}">
	<a href="notice-?PAGE_NO=${page }">${page }</a>
</c:forEach>
<c:if test="${! NOTICE_LIST.lastPage}">
	<a href="notice-?LAST_SEQNO=${NOTICE_LIST.seqNoList[NOTICE_LIST.listSize -1] }">다음 페이지</a>
</c:if>
</body>
</html>