<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
div{
		text-align: center;
	}
</style>
</head>
<body>
<h3>정보 입력 폼</h3>
<form method="post" action="JSP_Test_06_2_itemWrite.jsp">
	<table>
		<tr>
			<td>상품명		</td>
			<td><input type="text" name="name" size="30"></td>
		</tr>
		<tr>
			<td>가격		</td>
			<td><input type="text" name="price" size="30"></td>
		</tr>
		<tr>
			<td>설명		</td>
			<td><textarea rows="20" cols="70" name="description"></textarea></td>
		</tr>
	</table>
	<div>
		<input type="submit" value="send">
		<input type="reset" value="cancle">
	</div>
</form>
</body>
</html>