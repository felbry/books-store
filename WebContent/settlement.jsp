<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userInstance" type="bean.Users" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/baseforjsp.css" media="screen" title="no title">
<link rel="stylesheet" href="css/settlement.css" media="screen" title="no title">
<title>结算</title>
</head>
<body>
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
    <div class="banner">结算</div>
    <div class="collapse">
      <div class="goods">
        <!--
        <div class="good">
          <div class="face"><img src="images/book/book05.jpg" alt="" /></div>
          <div class="title">this is a title</div>
          <div class="price">25</div>
          <div class="count">3</div>
          <div class="totalPrice">26.3</div>
        </div>
        <div class="good">
          <div class="face"><img src="images/book/book05.jpg" alt="" /></div>
          <div class="title">this is a title</div>
          <div class="price">25</div>
          <div class="count">3</div>
          <div class="totalPrice">26.3</div>
        </div>
        <div class="good">
          <div class="face"><img src="images/book/book05.jpg" alt="" /></div>
          <div class="title">this is a title</div>
          <div class="price">25</div>
          <div class="count">3</div>
          <div class="totalPrice">26.3</div>
        </div>
      -->
      </div>
      <div class="total">
        <div class="info">
          <div class="enter">
            <label for="receiver">收货人：</label>
            <input type="text" id="receiver">
          </div>
          <div class="enter">
            <label for="tel">手机号：</label>
            <input type="text" id="tel">
          </div>
          <div class="enter">
            <label for="address">收货地址：</label>
            <input type="text" id="address">
          </div>
        </div>
        <div class="p"></div>
        <div class="sub"><button type="button" name="submitbtn">提交订单</button></div>
      </div>
    </div>
  </div>

  <script src="js/jquery.min.js"></script>
  <script src="js/json2.js"></script>
  <script src="js/settlement.js"></script>
</body>
</html>
