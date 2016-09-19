$(function(){
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

  //首页图书信息展示
  $.get('bookIndex', function(data){
    for(var i = 0, len = data.length; i < len; i++) {
      var div = $('<div class="collapse">\
        <a href="bookId?id=' + data[i].id + '"><img src="' + data[i].faceimg + '" alt=""></a>\
        <a href="bookId?id=' + data[i].id + '"><b>' + data[i].title + '</b></a>\
        <p>¥' + data[i].price + '</p>\
      </div>');
      $('.body').append(div, div, div);
    }
  })

  //购物车图标点击弹出侧边栏
  $('.cart i').on('click', function(){
    $('.sidebar').css('right', '0px');

    //获取最新购物车中的数据填充
    getCartBooks();
  })

  //抓取uid所选的所有图书并对元素绑定事件
	function getCartBooks() {
		$('.sidebar .mid').html('');
		var getByUid = {
				uid: UID
		};
		var gbu = JSON.stringify(getByUid);
		$.post('cart', {book: gbu, flags: 'get'}, function(data){
      var totalprice = 0;
      for(var i = 0, len = data.length; i < len; i++) {
        totalprice += data[i].totalPrice;
        var good = $('<div class="good">\
          <div class="title">' + data[i].title + '</div>\
          <div class="detail">\
            <div class="num">\
              <div class="decrease"><i class="minus-add" data-bid="' + data[i].bid + '">&#xe69b;</i></div>\
              <div class="count">' + data[i].counts + '</div>\
              <div class="add"><i class="minus-add" data-bid="' + data[i].bid + '">&#xe69c;</i></div>\
            </div>\
            <div class="totalprice">¥' + data[i].totalPrice + '</div>\
            <div class="delbtn"><button type="button" name="button" data-bid="' + data[i].bid + '">删除</button></div>\
          </div>\
        </div>');
        $('.sidebar .mid').append(good);
      }

      $('.sidebar .bottom .total .amount').text('已选' + data.length + '件');
      $('.sidebar .bottom .total .totalprice').text('¥' + totalprice);

      //购物车中的增加和减少,(如果放在此函数外边,因为动态加载捕捉不到)
      $('.good i').on('click', function() {
        var flags = $(this).parent().attr('class');
        var bids = $(this).attr('data-bid');
        var nums = $(this).parent().parent().find('div[class="count"]').text();
        if(flags == 'add') {
          var obj = {
            uid: UID,
            bid: bids
          }
          var objstr = JSON.stringify(obj);
          $.post('cart', {book: objstr, flags: 'add'}, function(){
            getCartBooks();
          })
        } else if(flags == 'decrease') {
          if(nums == 1)
            return false;
          else {
            var obj = {
              uid: UID,
              bid: bids
            }
            var objstr = JSON.stringify(obj);
            $.post('cart', {book: objstr, flags: 'subtract'}, function(){
              getCartBooks();
            })
          }
        } else {
          console.log('error');
        }
      })

      //删除某本图书操作
      $('.good button').on('click', function(){
        var bids = $(this).attr('data-bid');
        var obj = {
          uid: UID,
          bid: bids
        }
        var objstr = JSON.stringify(obj);
        $.post('cart', {book: objstr, flags: 'del'}, function(){
          getCartBooks();
        })
      })
		});
	}

  //结算功能
  $('.settlementbtn').on('click', function() {
    window.location.href = 'settlement.jsp';
  })

  //收起侧边栏
  $('.sidebar .top').on('click', function(){
    $('.sidebar').css('right', '-250px');
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
