<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="empty" %>
<%@ attribute name="size" type="java.lang.Integer"%>
<%@ attribute name="color" %>


<font color="${color }">
<%
	for(int cnt = 0 ; cnt <size ; cnt++){
		out.print("=");
	}

%>
</font><br>