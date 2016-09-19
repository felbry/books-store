$(function() {
  var orderId = $('#orderId').text();
  $.post('detailOrder', {id: orderId, flags: 'getDetail'}, function(data) {
    console.log(data);
    //先遍历bookDetail生成图书详情（和settlement逻辑一致）
    var books = JSON.parse(data[0].bookDetail);
    $('.goods').html('');
    var totalprice = 0;
    for(var i = 0, len = books.length; i < len; i++) {
      totalprice += books[i].totalPrice;
      var good = $('<div class="good">\
        <div class="face"><img src="' + books[i].face + '" alt="" /></div>\
        <div class="title">' + books[i].title + '</div>\
        <div class="price">' + books[i].price + '</div>\
        <div class="count">' + books[i].counts + '</div>\
        <div class="totalPrice">' + books[i].totalPrice + '</div>\
      </div>');
      $('.goods').append(good);
    }
    $('.p').text(totalprice);

    $('input[id="receiver"]').val(data[0].receiver);
    $('input[id="tel"]').val(data[0].rPhone);
    $('input[id="address"]').val(data[0].rAddress);
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
