<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member" class="com.test.six.MemberBean"/>

자바빈 생성후 output <br><br>
name : <%=member.getName() %><br>
id : <%=member.getUserid() %>

<hr>

정보 변경한 후 output<br><br>
<%
	member.setName("test01");
	member.setUserid("test111");
%>
name : <%=member.getName() %><br>
id : <%=member.getUserid() %>
</body>
</html>