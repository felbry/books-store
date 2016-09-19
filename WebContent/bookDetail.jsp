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
    <link rel="stylesheet" href="css/bookDetail.css" media="screen" title="no title">
    <title>图书详情</title>
  </head>
  <body>
    <p id="bookId" style="display: none"><%= request.getParameter("id") %></p>
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
          <div class="amount">已选2件</div>
          <div class="totalprice">¥108.5</div>
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
      <div class="face">
        <img src="images/book/book05.jpg" width="250px">
      </div>
      <div class="info">
        <div class="title">于丹：此心光明万物生（当当独家签名版）</div>
        <div class="describe">于丹国学美文全新力作，微信公众号“水木文摘”联合预售。限量签名版+宽幅精美国画，先到先得。国学之思，美文之形，生活之用。打破偏见，重开视野，让你看见中国人美好的样子。</div>
        <div class="original">
          <p class="author">作者:于丹</p>
          <p class="publisher">出版社:长江文艺出版社</p>
        </div>
        <div class="price">¥25.20</div>
        <div class="add">
          <div class="nums">
            <div class="decreased"><i class="minus-add" id="m">&#xe69b;</i></div>
            <div class="counts">1</div>
            <div class="added"><i class="minus-add" id="a">&#xe69c;</i></div>
          </div>
          <div class="atc">
            <button type="button" name="addtocart">加入购物车</button>
          </div>
        </div>
      </div>
    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/json2.js"></script>
    <script src="js/bookDetail.js"></script>
</body>
</html>
