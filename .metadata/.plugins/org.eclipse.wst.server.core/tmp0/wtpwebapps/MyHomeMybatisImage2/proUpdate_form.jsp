<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function validate(form){
	if(form.name.value == ""){
		alert("제목을 입력하세요."); return false;
	}
	if(form.id.value == ""){
		alert("작성자를 입력하세요."); return false;
	}
	if(form.price.value == ""){
		alert("가격을 입력하세요."); return false;
	}
	if(form.password.value == ""){
		alert("암호를 입력하세요."); return false;
	}
	var result = confirm("정말로 변경하시겠습니까?");
	if(result == false) return false;
}
</script>

<form action="proupdate.do" method="post" onSubmit="return validate(this)">
	<input type="hidden" name="id" value="${pro.pid }"/>

	<table width="100%" border="1">
		<tr>
			<td>상품명</td>
			<td><input type="text" name="name" size="20" value="${pro.name }"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="wid" size="30" value="${pro.id }"/></td>
		</tr>
		<tr>
			<td>가 격</td>
			<td><input type="text" name="price" size="20" value="${pro.price }"/></td>
		</tr>
		<tr>
			<td>암 호</td>
			<td><input type="password" name="password" size="20"/></td>
		</tr>
		<tr>
		<td>글내용</td>
			<td><textarea rows="8" cols="40" name="content">${pro.content }</textarea></td>
		</tr>
		<tr><td colspan="2">
			<input type="submit" value="수 정"/>
			<input type="button" value="취 소" onClick="javascript:history.go(-1)"/></td>
		</tr>
	</table>
</form>
</body>
</html>