<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<fmt:setBundle basename="intro"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="TITLE"></fmt:message></title>
</head>
<body>
<h1 align="center"><fmt:message key="TITLE"></fmt:message></h1>
<fmt:message key="GREETING"></fmt:message><br>
<fmt:message key="BODY"></fmt:message><br>
<font size="3"><fmt:message key="COMPANY_NAME"></fmt:message></font><br>
</body>
</html>