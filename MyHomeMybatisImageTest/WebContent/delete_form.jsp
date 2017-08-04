<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="delete.do" method="post" onSubmit="return validate(this)">
	<input type="hidden" name="id" value="${writing.writing_id }">
	<table>
		<tr>
			<tr>
			<td>글제목</td>
			<td>${writing.title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${writing.writer_name }</td>
		</tr>
		<tr>
			<td>암호</td>
			<td><input type="password" name="password" size="15"></td>			
		</tr>
		<tr>
			<td>이미지</td>
			<td><img alt="" src="uploadfiles/${writing.image_name }"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="delete"/>
				<input type="button" value="cancle" onClick="javascript:history.go(-1)"/>
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript">
	function validate(form){
		if(form.password.value==""){
			alert("this delete? need password"); return false;
		}
		
		var result=comfim("real?");
		
		if(result==false) return false;
	}
</script>
</body>
</html>