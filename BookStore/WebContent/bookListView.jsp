<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보</title>
<style>
	#r_table {
		border: 1px solid black;
		border-collapse: collapse;
		margin: auto;
	}
	#r_table th {
		background-color: #c9c9c9;
	}
	#r_table tr:nth-child(2n) {
		background-color: #e8e8e8;
	}
	#r_table td:nth-child(1) {
		text-align: center;
		width: 40px;
	}
	#r_table td:nth-child(2) {
		width: 250px;
		padding: 0 0 0 5px;
	}
	#r_table td:nth-child(3) {
		width: 80px;
		text-align: right;
		padding: 0 5px 0 0;
	}
	#r_table td:nth-child(4) {
		width: 55px;
		text-align: center;
	}
	#r_table td:nth-child(5) {
		width: 130px;
		text-align: center;
	}
	#r_table td:nth-child(6) {
		width: 50px;
		text-align: center;
	}
</style>
</head>
<body>
	<h1 align="center">상품 목록</h1>
	[페이지 갯수] : ${BOOK_LIST.pageNum}
	<table id="b_table" border="1">
		<tr>
			<th>도서코드</th>
			<th>책이름</th>
			<th>저자</th>
			<th>출판사</th>
			<th>가격</th>
			<th>등록일</th>
			<th>담기</th>
		</tr>
		<c:forEach var="cnt" begin="0" end="${BOOK_LIST.listSize-1}">
			<tr>
				<td>${BOOK_LIST.bookCodeList[cnt]}</td><!-- 웹서버는 BOOK_LIST 객체에 들어가서 bookCodeList에 자동으로 -->
				<td><a href="bookItem?BOOKCODE=${BOOK_LIST.bookCodeList[cnt]}">${BOOK_LIST.bookTitleList[cnt]}</a></td><!-- get을 붙여서 getSeqNoList()로 찾게된다. -->
				<td>${BOOK_LIST.companyList[cnt]}</td>
				<td>${BOOK_LIST.writerList[cnt]}</td>
				<td><fmt:formatNumber groupingUsed="true">${BOOK_LIST.priceList[cnt]}</fmt:formatNumber>원</td><!-- 그렇기 때문에 BBSList 빈 파일에 getter메서드를 작성해 주어야 한다. -->
				<td>${BOOK_LIST.regDateList[cnt]}</td>
				<td><input type="button" onClick="window.open('add-cart?BOOK_CODE=${BOOK_LIST.bookCodeList[cnt]}','Cart_result','width=400, height=150').focus()" value="장바구니"></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center">
				<c:if test="${!BOOK_LIST.firstPage}">
					<a href="book-list?FIRST_BOOKCODE=${BOOK_LIST.bookCodeList[0]}">이전 페이지</a>&nbsp;|&nbsp;
				</c:if>
				<c:forEach var="page" begin="1" end="${BOOK_LIST.pageNum}">
					<a href="book-list?PAGE_NO=${page}">${page}</a>
				</c:forEach>
				<c:if test="${!BOOK_LIST.lastPage}">
					&nbsp;|&nbsp;<a href="book-list?LAST_BOOKCODE=${BOOK_LIST.bookCodeList[BOOK_LIST.listSize -1]}">다음 페이지</a>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>