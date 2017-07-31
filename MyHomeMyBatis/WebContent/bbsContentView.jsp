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
[글번호] : ${BBS_ITEM.seqno }<br>
[글제목] : ${BBS_ITEM.title }<br>
[작성자] : ${BBS_ITEM.writer }, [작성일] : ${BBS_ITEM.date }<br>
-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*<br>
${BBS_ITEM.content}
</body>
</html>