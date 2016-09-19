$(function() {
  var UID = '',
      DATAJSON = '';
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

  var getByUid = {
      uid: UID
  };
  var gbu = JSON.stringify(getByUid);
  //加载购物车中的信息
  $.post('cart', {book: gbu, flags: 'get'}, function(data) {
    console.log(data);
    $('.goods').html('');
    var totalprice = 0;
    for(var i = 0, len = data.length; i < len; i++) {
      totalprice += data[i].totalPrice;
      var good = $('<div class="good">\
        <div class="face"><img src="' + data[i].face + '" alt="" /></div>\
        <div class="title">' + data[i].title + '</div>\
        <div class="price">' + data[i].price + '</div>\
        <div class="count">' + data[i].counts + '</div>\
        <div class="totalPrice">' + data[i].totalPrice + '</div>\
      </div>');
      $('.goods').append(good);
    }
    $('.p').text(totalprice);
  })

  //提交订单
  $('button').on('click', function() {
    $.ajax({
      type: 'post',
      async: false,
      url: 'cart',
      data: {
        book: gbu,
        flags: 'get'
      },
      success: function(data){
        DATAJSON = JSON.stringify(data);
      }
    })

    var datastr = JSON.stringify(DATAJSON);
    var order = {
      uid: UID,
      totalPrice: $('.p').text(),
      receiver: $('input[id="receiver"]').val(),
      rPhone: $('input[id="tel"]').val(),
      rAddress: $('input[id="address"]').val(),
      bookDetail: DATAJSON
    }
    var orderStr = JSON.stringify(order);
    $.post('cart', {order: orderStr, flags: 'settlement'}, function() {
      window.location.href = 'orders.jsp';
    });
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
