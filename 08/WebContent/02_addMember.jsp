<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page  import="java.sql.DriverManager"%>
<%@page  import="java.sql.PreparedStatement"%>
<%@page  import="java.sql.Connection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String uid="hr";
	String pass="1234";
	String sql="insert into member values(?,?,?,?,?,?)";
%>

<%
	request.setCharacterEncoding("UTF-8");

	String name=request.getParameter("name");
	String userid=request.getParameter("userid");
	String pwd=request.getParameter("pwd");
	String email=request.getParameter("email");
	String phone=request.getParameter("phone");
	String admin=request.getParameter("admin");
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection(url,uid,pass);
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, userid);
		pstmt.setString(3, pwd);
		pstmt.setString(4, email);
		pstmt.setString(5, phone);
		pstmt.setInt(6, Integer.parseInt(admin));
		
		pstmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(pstmt==null)pstmt.close();
			if(conn==null)conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
<h3>success</h3>
<a href="01_allMember.jsp">list</a>
</body>
</html>