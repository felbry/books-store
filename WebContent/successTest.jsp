<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:useBean id="userInstance" type="bean.Users" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Register Successfully</title>
</head>
<body>
	Register Successfully.<br>
	Your username:<jsp:getProperty property="username" name="userInstance"/><br>
	Your password:<jsp:getProperty property="password" name="userInstance"/>
</body>
</html>