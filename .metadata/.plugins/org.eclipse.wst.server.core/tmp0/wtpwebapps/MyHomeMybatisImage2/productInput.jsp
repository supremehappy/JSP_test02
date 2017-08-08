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
		if(form.PRONAME.value == ""){
			alert("plz, input name");
			return false;
		}
		
		if(form.password.value == ""){
			alert("plz, input password");
			return false;
		}
		
		if(form.PROPRICE.value == ""){
			alert("plz, input price");
			return false;
		}
		
		if(form.CONTENT.value == ""){
			alert("plz, input content");
			return false;
		}
		
		
	}
</script>

	<form action="pro-post" method="post" onSubmit="return validate(this)">
	
		<c:if test="${! empty pro.group_id }">
			<input type="hidden" name ="groupid" value="${param.groupid }"/>
		</c:if>
		
		<c:if test="${! empty pro.parent_id }">
			<input type="hidden" name ="parentid" value="${param.parentid }"/>
		</c:if>
	
		<input type="hidden" name="orderno" value="${param.order_no+1 }" />
		
		<table border="1" width="100%">
		
			<tr><td>상품명</td>
				<td><input type="text" name="PRONAME" size="40" value="${title }" /></td>
			</tr>	
			<tr><td>가 격</td>
				<td><input type="text" name="PROPRICE" size="30"/></td>
			</tr>
			<tr><td>암호</td>
				<td><input type="password" name="password" size="20"/></td>
			</tr>
			<tr><td>글내용</td>
				<td><textarea rows="8" cols="40" name="CONTENT"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="등 록"/>
				<input type="reset" value="취 소"/>
				</td>
			</tr>	
		</table>
	</form>
</body>
</html>