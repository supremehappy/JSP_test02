<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>test</h3>
<%
	String id_str = session.getId();
	long lasttime = session.getLastAccessedTime();
	long createdtime = session.getCreationTime();
	long time_used= (lasttime-createdtime)/60000;
	int inactive = session.getMaxInactiveInterval()/60;
	boolean b_new = session.isNew();
%>
1. session id [<%=session.getId() %>]<br><hr>
2. 머문시간 <%=time_used %><br><hr>
3. 세션 유효시간 <%=inactive %><br><hr>
4. new session?
<%
	if(b_new){
		out.print("yes");
	}else{
		out.print("no");
	}
%>
</body>
</html>