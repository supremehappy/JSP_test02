<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="script/member.js" ></script>

<h2>id check</h2>
<form action="idCheck.do" method="get" name="frm">
	id <input type="text" name="userid" value="${userid }">
	<input type="submit" value="check" >
	<br>
	<c:if test="${result==1 }">
		<script type="text/javascript">
			opener.document.frm.userid.value="";
		</script>
		${userid } already used id
	</c:if>
	<c:if test="${result==-1 }">
		${userid } use to id
		<input type="button" value="use" class="cancel" onclick="idok()"> 
	</c:if>
</form>
</body>
</html>