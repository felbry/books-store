<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="css/baseforjsp.css" media="screen" title="no title">
  <link rel="stylesheet" href="css/login.css" media="screen" title="no title">
  <title>Login</title>
</head>
<body>
  <div class="collapse">
    <div class="enter">
      <label for="username">用户名：</label>
      <input type="text" id="username">
    </div>
    <div class="enter">
      <label for="password">密码：</label>
      <input type="text" id="password">
    </div>
    <div class="btn-team">
      <button class="btn" id="login">登录</button>
      <button class="btn" id="register" src="register.jsp">注册</button>
    </div>
    <div class="warning">
      <small>用户名或密码错误，请重新输入</small>
    </div>
  </div>
  <script src="js/jquery.min.js"></script>
  <script src="js/json2.js"></script>
  <script src="js/login.js"></script>
</body>
</html>
