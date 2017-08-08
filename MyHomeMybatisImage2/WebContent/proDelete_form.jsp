<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="prodelete.do" method="post" onSubmit="return validate(this)">
	<input type="hidden" name="id" value="${pro.pid }"/>
	<table width="100%" border="1">
		<tr>
			<td>글제목</td>
			<td>${pro.name }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${pro.id }</td>
		</tr>
		<tr>
			<td>가 격</td>
			<td>${pro.price }</td>
		</tr>
		<tr>
		<td>암 호</td>
			<td>
			<input type="password" name="password" size="25"/></td>
		</tr>
		<tr>
			<td>글내용</td>
			<td>${pro.content }</td>
		</tr>
		<tr><td colspan="2">
			<input type="submit" value="삭제">
			<input type="button" value="취소" onClick="javascript:history.go(-1)"/></td>
		</tr>
	</table>
</form>
<script type="text/javascript">
function validate(form){
	if(form.password.value == ""){
		alert("삭제하려면 암호를 입력해야 합니다."); return false;
	}
	var result=confirm("정말로 삭제하시겠습니까?");
	if(result == false) return false;
}
</body>
</html>