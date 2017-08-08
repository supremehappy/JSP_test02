<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function validate(form){
 	if(form.title.value ==""){
 		alert("제목을 입력하세요."); return false;
 	}
 	if(form.nick.value == ""){
 		alert("닉네임을 입력하세요."); return false;
 	}
 	if(form.password.value==""){
 		alert("암호를 입력하세요."); return false;
 	}
 	if(form.imagename.value==""){
 		alert("이미지 파일을 선택하세요."); return false;
 	}
 	var result = confirm("정말로 등록하시겠습니까?");
 	if(result == false) return false;
}
</script>

<form action="write.do" method="post" enctype="multipart/form-data" onSubmit="return validate(this)">

	<c:if test="${! empty writing.group_id }">
		<input type="hidden" name ="groupid" value="${param.groupid }"/>
	</c:if>
	
	<c:if test="${! empty writing.parent_id }">
		<input type="hidden" name ="parentid" value="${param.parentid }"/>
	</c:if>

	<input type="hidden" name="orderno" value="${param.order_no+1 }" />

	<table border="1" width="100%">
		<tr><td>글제목</td>
		<td><input type="text" name="title" size="40" value="${title }"/></td>
		</tr>	
		<tr><td>닉네임</td>
		<td><input type="text" name="nick" size="20"/></td>
		</tr>
		<tr><td>이메일</td>
		<td><input type="text" name="email" size="40"/></td>
		</tr>	
		<tr><td>암호</td>
		<td><input type="password" name="password" size="20"/></td>
		</tr>
		<tr><td>이미지</td>
		<td><input type="file" name="imagename" size="40"/></td>
		</tr>	
		<tr><td>글내용</td>
		<td><textarea rows="8" cols="40" name="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="등 록"/>
			</td>
		</tr>	
	</table>
</form>
</body>
</html>