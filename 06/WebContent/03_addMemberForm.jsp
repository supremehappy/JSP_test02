<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>add member</h2>
<form method="post" action="03_addMember.jsp">
	<table>
		<tr>
			<td>name 	</td>
			<td><input type="text" name="name" size="20"></td>
		</tr>
		<tr>
			<td>id 	</td>
			<td><input type="text" name="userid" size="20"></td>
		</tr>
		<tr>
			<td>nickname 	</td>
			<td><input type="text" name="nickname" size="20"></td>
		</tr>
		<tr>
			<td>password 	</td>
			<td><input type="password" name="pw" size="20"></td>
		</tr>
		<tr>
			<td>email 	</td>
			<td><input type="text" name="email" size="20"></td>
		</tr>
		<tr>
			<td>phone 	</td>
			<td><input type="text" name="phone" size="20"></td>
		</tr>
		<tr>
			<td><input type="submit" value="send"></td>
			<td><input type="reset" value="cancle"></td>
		</tr>
	</table>
</form>
</body>
</html>