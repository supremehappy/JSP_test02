<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">게시글 읽기</h2>
[글번호] : ${NOITCE_ITEM.seqno }<br/>
[글제목] : ${NOITCE_ITEM.title }<br/>
[작성자] : ${NOITCE_ITEM.id },[작성일] : ${NOITCE_ITEM.bbs_date }<br/>
======================================================<br/>
${NOITCE_ITEM.content }
</body>
</html>