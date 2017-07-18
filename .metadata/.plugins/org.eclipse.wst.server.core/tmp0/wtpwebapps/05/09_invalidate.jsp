<%@page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.setAttribute("s_name", "first value");
	session.setAttribute("s_name1", "second value");
	session.setAttribute("s_name2", "third value");
	
	out.print("<h3> 삭제전 </h3>");
	
	Enumeration names;
	names=session.getAttributeNames();
	while(names.hasMoreElements()){
		String name=names.nextElement().toString();
		String value = session.getAttribute(name).toString();
		out.println(name+" : " +value + "<br>");
	}
	session.invalidate();
	
	out.print("<hr><h3>삭제후</h3>");
	out.print("session id 유효?<br>");
	
	if(request.isRequestedSessionIdValid()==true){
		out.print("yes");
	}else{
		out.print("no");
	}

%>

</body>
</html>