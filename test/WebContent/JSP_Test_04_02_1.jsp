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
	int num = Integer.parseInt(request.getParameter("num"));
	int sum=0;
	
	for(int i = 1; i<=num; i++){
		sum+=i;
		if(i==num){
			out.print(i);
		}else{
			out.print(i+" + ");	
		}
	}
	out.print(" = "+sum);
%>
</body>
</html>