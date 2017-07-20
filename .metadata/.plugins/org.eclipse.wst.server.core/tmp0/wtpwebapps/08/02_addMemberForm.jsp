<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>입력 폼</h2>
<form method="post" action="02_addMember.jsp">
	<table>
		<tr>
			<td>이름 			</td>
			<td><input type="text" name="name" size="20"></td>
		</tr>
		<tr>
			<td>아디 			</td>
			<td><input type="text" name="userid" size="20"></td>
		</tr>
		<tr>
			<td>비번 			</td>
			<td><input type="text" name="pwd" size="20"></td>
		</tr>
		<tr>
			<td>이멜 			</td>
			<td><input type="text" name="email" size="20"></td>
		</tr>
		<tr>
			<td>폰번 			</td>
			<td><input type="text" name="phone" size="20"></td>
		</tr>
		<tr>
			<td>등급 			</td>
			<td>
			<input type="radio" name="admin"  value="1" checked="checked">admin
			<input type="radio" name="admin"  value="0">nomal
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="send"></td>
			<td><input type="reset" value="cancle"></td>
		</tr>
	</table>
</form>
</body>
</html>