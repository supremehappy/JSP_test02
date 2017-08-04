<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보</title>
</head>
<body>
	<h2 align="center">상품 읽기</h2>
	[도서번호] : ${BOOK_ITEM.book_code}, [출판사] : ${BOOK_ITEM.company}<br>
	[도서제목] : ${BOOK_ITEM.book_title}<br>
	[저자] : ${BOOK_ITEM.writer}, [작성일] : ${BOOK_ITEM.reg_date}<br>
	==========================================================<br>
	
</body>
</html>