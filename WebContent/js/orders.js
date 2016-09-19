$(function() {
  var UID = '';
  //获取用户id
  $.ajax({
    type: 'post',
    async: false,
    url: 'getUid',
    data: {
      username: $('#user').text()
    },
    success: function(uids){
      UID = uids;
    }
  })

  var orders = {
    uid: UID
  }
  var orderStr = JSON.stringify(orders);

  $.post('allOrders', {order: orderStr, flags: 'all'}, function(data) {
    console.log(data);
    $('.list').html('');
    for(var i =0, len = data.length; i < len; i++) {
      var order = $('<div class="order">\
        <div class="id">' + data[i].id + '</div>\
        <div class="date">' + data[i].buyDate + '</div>\
        <div class="totalprice">' + data[i].totalPrice + '</div>\
        <div class="link"><a href="detailOrder?id=' + data[i].id + '&flags=detail">查看详细 >></a></div>\
      </div>');
      $('.list').append(order);
    }
  })

  //首页
  $('.header .title').on('click', function(){
    window.location.href = 'index.jsp';
  })

  //鼠标悬浮用户名操作
  $('.message').on({
    mouseover: function() {
      $('.options').css('display', 'block');
    },
    mouseout: function() {
      $('.options').on('mouseover', function() {
        $('.options').css('display', 'block');
      });

      $('.options').on('mouseout', function() {
        $('.options').css('display', 'none');
      });
    }
  });

  //查看订单
  $('.lookOrder').on('click', function() {
    window.location.href = 'orders.jsp';
  })
})
