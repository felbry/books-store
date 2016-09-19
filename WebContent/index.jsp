<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userInstance" type="bean.Users" scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/baseforjsp.css" media="screen" title="no title">
    <link rel="stylesheet" href="css/index.css" media="screen" title="no title">
    <title>首页</title>
  </head>
  <body>
    <div class="cart">
      <i class="cart-font">&#xe67a;</i>
    </div>
    <!-- 购物车 -->
    <div class="sidebar">
      <div class="top">点击收起 ></div>
      <div class="mid">
        <!--
        <div class="good">
          <div class="title">钢铁是怎样炼成的是怎样是怎样</div>
          <div class="detail">
            <div class="num">
              <div class="decrease"><i class="minus-add">&#xe69b;</i></div>
              <div class="count">25</div>
              <div class="add"><i class="minus-add">&#xe69c;</i></div>
            </div>
            <div class="totalprice">¥25.35</div>
            <div class="delbtn"><button type="button" name="button">删除</button></div>
          </div>
        </div>
        <div class="good">
          <div class="title">钢铁是怎样炼成的</div>
          <div class="detail">
            <div class="num">
              <div class="decrease"><i class="minus-add">&#xe69b;</i></div>
              <div class="count">2</div>
              <div class="add"><i class="minus-add">&#xe69c;</i></div>
            </div>
            <div class="totalprice">¥255.35</div>
            <div class="delbtn"><button type="button" name="button">删除</button></div>
          </div>
        </div>
      -->
      </div>
      <div class="bottom">
        <div class="total">
          <div class="amount"></div>
          <div class="totalprice"></div>
        </div>
        <div class="settlementbtn">结算</div>
      </div>
    </div>

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
      <!--
      <div class="collapse">
        <a><img src="images/book/book04.jpg" alt=""></a>
        <a href=""><b>钢铁是怎样炼成的</b></a>
        <p>¥25.23</p>
      </div>
      <div class="collapse">
        <a><img src="images/book/book05.jpg" alt=""></a>
        <a href=""><b>钢铁是怎样炼成的</b></a>
        <p>¥25.23</p>
      </div>
      <div class="collapse">
        <a><img src="images/book/book04.jpg" alt=""></a>
        <a href=""><b>钢铁是怎样炼成的</b></a>
        <p>¥25.23</p>
      </div>
    -->
    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/json2.js"></script>
    <script src="js/index.js"></script>
</body>
</html>
