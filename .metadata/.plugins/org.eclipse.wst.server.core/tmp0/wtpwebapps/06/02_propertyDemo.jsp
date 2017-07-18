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
<hr>
빈 생성후 output<br><br>
name : <jsp:getProperty property="name" name="member"/><br>
id : <jsp:getProperty property="userid" name="member"/>
<hr>

변경후 output<br><br>
<jsp:setProperty property="name" name="member" value="est11"/>
<jsp:setProperty property="userid" name="member" value="ex21"/>
name : <jsp:getProperty property="name" name="member"/><br>
id : <jsp:getProperty property="userid" name="member"/>

</body>
</html>