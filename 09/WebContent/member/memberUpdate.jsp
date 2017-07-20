<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="script/member.js" ></script>

<h2>수정</h2>

<form action="memberUpdate.do" method="post" name="frm">
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
			<td>password 	</td>
			<td><input type="password" name="pwd" size="20">*</td>
		</tr>
		<tr>
			<td>pw check 	</td>
			<td><input type="password" name="pwd_check" size="20">*</td>
		</tr>
		<tr>
			<td>email 	</td>
			<td><input type="text" name="email" size="20" value="${mVo.email }"></td>
		</tr>
		<tr>
			<td>phone 	</td>
			<td><input type="text" name="phone" size="20" value="${mVo.phone }"></td>
		</tr>
		<tr>
			<td>admin 	</td>
			<td>
				<c:choose>
					<c:when test="${mVo.admin==0}">
						<input type="radio" name="admin" value="0" checked="checked">nomal
						<input type="radio" name="admin" value="1" >admin
					</c:when>
					<c:otherwise>
						<input type="radio" name="admin" value="0" >nomal
						<input type="radio" name="admin" value="1" checked="checked">admin
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="ok" onclick="return joinCheck()">&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				<input type="reset" value="cancle">
			</td>
		</tr>
	</table>
</form>
</body>
</html>