<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h2{
		text-align: center;
	}
	div{
		text-align: center;
	}
</style>
</head>
<body>
<form method="post" action="JSP_Test_06_1_boardWrite.jsp">
	<h2>게시판 글쓰기</h2>
	<br>
	<table>
		<tr>
			<td><label><b>작성자		</b></label></td>
			<td><input type="text" name="name" size="20"></td>
		</tr>
		<tr>
			<td><label><b>비번		</b></label></td>
			<td><input type="password" name="pass" size="20"></td>
			<td><p>게시물 수정시 필요</p></td>
		</tr>
		<tr>
			<td><label><b>이메일		</b></label></td>
			<td><input type="text" name="email" size="40"></td>
		</tr>
		<tr>
			<td><label><b>글제목		</b></label></td>
			<td><input type="text" name="title" size="80"></td>
		</tr>
		<tr>
			<td><label><b>글내용		</b></label></td>
			<td><textarea rows="10" cols="70" name="content"  ></textarea></td>
		</tr>
	</table>
	<div>
		<input type="submit" value="등록">
		<input type="reset" value="다시작성">
	</div>
</form>
</body>
</html>