$(function(){
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

	//购物车图标点击弹出侧边栏
  $('.cart i').on('click', function(){
    $('.sidebar').css('right', '0px');
    getCartBooks();
  })
  //收起侧边栏
  $('.sidebar .top').on('click', function(){
    $('.sidebar').css('right', '-250px');
  })

  //添加购物按钮旁边的加减键
  $('.nums i').on('click', function(){
    //console.log(e);
    var flags = $(this).attr('id');
        count = $('.counts').text();
    console.log(flags + ', ' + count);
    if(flags == 'm') {
      if(count == 1)
        return false;
      else {
        count--;
        $('.counts').text(count);
      }
    } else if(flags == 'a') {
      count++;
      $('.counts').text(count);
    } else {
      console.log('error');
    }
  })

  //购物车中的加减键


  //首页
  $('.header .title').on('click', function(){
    window.location.href = 'index.jsp';
  })

	var UID = '';

  //得到图书详情
	$.ajax({
		type: 'post',
		async: false,
		url: 'bookDetail',
		data: {
			id: $('#bookId').text()
		},
		success: function(bookInfos){
      $('.body .face img').attr('src', bookInfos.faceimg);
      $('.info .title').text(bookInfos.title);
      $('.info .describe').text(bookInfos.describe);
      $('.info .original .author').text('作者：' + bookInfos.author);
      $('.info .original .publisher').text('出版社：' + bookInfos.publisher);
      $('.info .price').text('¥' + bookInfos.price);
		}
	});
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

	//购物车按钮
	$('button[name="addtocart"]').on('click', function(){
		var obj = {
				uid: UID,
				price: $('.info .price').text().substring(1),
				totalPrice: $('.info .price').text().substring(1) * $('.info .add .nums .counts').text(),
				counts: $('.info .add .nums .counts').text(),
				bid: $('#bookId').text(),
				title: $('.info .title').text(),
				face: $('.body .face img').attr('src')
		};
		var objStr = JSON.stringify(obj);
		//改成异步
		$.post('cart', {book: objStr, flags: 'add'}, function(data){
			getCartBooks();
	 	})
	});

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

})
