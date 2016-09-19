<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userInstance" type="bean.Users" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/baseforjsp.css" media="screen" title="no title">
<link rel="stylesheet" href="css/orders.css" media="screen" title="no title">
<title>全部订单</title>
</head>
<body>
  <!-- 页面主体 -->
  <div class="header">
      <div class="title">全部商品</div>
      <div class="message">
        <p id="user"><jsp:getProperty property="username" name="userInstance"/></p>
        <div class="options">
          <div class="lookOrder">
            <p>查看订单</p>
          </div>
          <div class="loginOut">
            <p><a href="loginOut">注销</a></p>
          </div>
        </div>
      </div>
    </div>
  <div class="body">
    <div class="banner">订单列表</div>
    <div class="list">
      <!--
      <div class="order">
        <div class="id">1</div>
        <div class="date">2016-09-15</div>
        <div class="totalprice">36</div>
        <div class="link"><a href="#">查看详细 >></a></div>
      </div>
      <div class="order">
        <div class="id">1</div>
        <div class="date">2016-09-15</div>
        <div class="totalprice">36</div>
        <div class="link"><a href="#">查看详细 >></a></div>
      </div>
    -->
    </div>
  </div>

  <script src="js/jquery.min.js"></script>
  <script src="js/json2.js"></script>
  <script src="js/orders.js"></script>
</body>
</html>
