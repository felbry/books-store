<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="css/baseforjsp.css" media="screen" title="no title">
  <link rel="stylesheet" href="css/register.css" media="screen" title="no title">
  <title>register</title>
</head>
<body>
  <div class="collapse">
    <div class="enter">
      <label for="username">用户名：</label>
      <input type="text" id="username" autofocus="">
    </div>
    <div class="warning username">
      <small>用户名不能少于6位</small>
    </div>
    <div class="enter">
      <label for="password">密码：</label>
      <input type="text" id="password">
    </div>
    <div class="warning password">
      <small>密码不能少于6位</small>
    </div>
    <div class="enter">
      <label for="passwordIdent">确认密码：</label>
      <input type="text" id="passwordIdent">
    </div>
    <div class="warning passwordIdent">
      <small>两次输入的密码不一致</small>
    </div>
    <div class="enter">
      <label for="tel">手机号：</label>
      <input type="text" id="tel">
    </div>
    <div class="warning tel">
      <small>请输入11位的有效手机号码</small>
    </div>
    <div class="enter">
      <label for="email">电子邮箱(选填)：</label>
      <input type="text" id="email">
    </div>
    <div class="btn-team">
      <button class="btn">注册</button>
    </div>
  </div>

  <script src="js/jquery.min.js"></script>
  <script src="js/json2.js"></script>
  <script src="js/register.js"></script>
</body>
</html>
