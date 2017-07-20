<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="script/member.js"></script>
<h2>join </h2>
'*' very important input data
<form action="join.do" method="post" name="frm">
	<table>
		<tr>
			<td>name		</td>
			<td><input type="text" name="name" size="20"></td>
		</tr>
		<tr>
			<td>id		</td>
			<td>
				<input type="text" name="userid"  id= "userid" size="20">*
				<input type="hidden" name="reid"  size="20">
				<input type="button" value="check" onclick="idCheck()">
			</td>
		</tr>
		<tr width="30">
			<td width="80">pw		</td>
			<td><input type="password" name="pwd" size="20">*</td>
		</tr>
		<tr>
			<td>email		</td>
			<td><input type="text" name="email" size="20"></td>
		</tr>
		<tr>
			<td>phone		</td>
			<td><input type="text" name="phone" size="20"></td>
		</tr>
		<tr>
			<td>admin		</td>
			<td>
				<input type="radio" name="admin" value="0" checked="checked">nomal
				<input type="radio" name="admin" value="1" >admin
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="ok" onclick="return joinCheck()">&nbsp;&nbsp;
				<input type="reset" value="cancle">
			</td>
		</tr>
		<tr><td colspan="2">${message }</td></tr>
	</table>
</form>
</body>
</html>