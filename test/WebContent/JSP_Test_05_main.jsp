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
	Cookie ck[]=null;
	
	//쿠키 얻어오기
	ck=request.getCookies();
	String t1 = "";
	if(ck!=null){
		// 쿠키에서 name 을 얻어 username 인지 비교해 같다면
		for(Cookie c : ck){
			String name=request.getParameter("name");
			if(c.getName()==name){
				t1=c.getName();
				out.println(c.getName()+" : "+c.getValue()+"<br>");
			}
		}
		// 쿠키 value 얻어와 출력
%>
<% for(Cookie c : ck){out.print(c.getValue());} %>, 하이<br>
<form method="post" action="JSP_Test_05_logout.jsp">
	<input type="submit" value="logout">
</form>
<%
	}else{
%>
<h2>login fail</h2>
<p><a href="JSP_Test_05_loginForm.jsp">return</a></p>
<%
	}
%>
</body>
</html>