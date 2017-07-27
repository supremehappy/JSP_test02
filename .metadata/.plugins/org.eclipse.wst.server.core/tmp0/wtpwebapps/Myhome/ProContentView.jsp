<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center"></h2>
[글번호] : ${PRO_ITEM.pid }<br>
[상품명] : ${PRO_ITEM.name }<br>
[가격] : ${PRO_price}, [작성자] : ${PRO_ITEM.writer }, [작성일] : ${PRO_ITEM.date }<br>
-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*<br>
${PRO_ITEM.content}
</body>
</html>