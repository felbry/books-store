$(function(){
  //表单规则验证
  $('#username').on('focusout', function(){
    var username = $('#username').val();
    if(username.length < 6)
      $('.username').css('display', 'flex');
    else
      $('.username').css('display', 'none');
  })

  $('#password').on('focusout', function(){
    var password = $('#password').val();
    if(password.length < 6)
      $('.password').css('display', 'flex');
    else
      $('.password').css('display', 'none');
  })

  $('#passwordIdent').on('focusout', function(){
    var password = $('#password').val();
    var passwordIdent = $('#passwordIdent').val();
    if(passwordIdent != password)
      $('.passwordIdent').css('display', 'flex');
    else
      $('.passwordIdent').css('display', 'none');
  })

  $('#tel').on('focusout', function(){
    var tel = $('#tel').val();
    if(tel.length != 11)
      $('.tel').css('display', 'flex');
    else
      $('.tel').css('display', 'none');
  })

  //注册提交
  $('.btn').on('click', function(){
    var flags = 0;
    validate();
    $('.warning').each(function(){
      if($(this).css('display') == 'flex')
        flags = 1;
    })
    if(flags == 1)
      return false;
    else if(flags == 0) {
      var user = $('#username').val(),
          pass = $('#password').val(),
          telphone = $('#tel').val(),
          ema = $('#email').val();
      var userInfo = {
      			username: user,
      			password: pass,
      			tel: telphone,
            email: ema
    		  };
      var userInfoStr = JSON.stringify(userInfo);
  		$.post('register', {userInfomation: userInfoStr}, function(data){
          $('body').html('');
          var div = $('<div>\
            注册成功，<p style="display: inline-block">3</p>秒后将自动登录\
          </div>');
          $('body').append(div);
          setInterval(function() {
            if($('p').text() == 1)
              window.location.href = 'index.jsp';
              $('p').text($('p').text() - 1);
          }, 1000);
  		})
    }
    else
      console.log('occur error');
  })

  function validate() {
    var username = $('#username').val(),
        password = $('#password').val(),
        passwordIdent = $('#passwordIdent').val(),
        tel = $('#tel').val();
    if(username.length < 6) {
      $('.username').css('display', 'flex');
    } else {
      $('.username').css('display', 'none');
    }

    if(password.length < 6) {
      $('.password').css('display', 'flex');
    } else {
      $('.password').css('display', 'none');
    }

    if(passwordIdent != password) {
      $('.passwordIdent').css('display', 'flex');
    } else {
      $('.passwordIdent').css('display', 'none');
    }

    if(tel.length != 11) {
      $('.tel').css('display', 'flex');
    } else {
      $('.tel').css('display', 'none');
    }
  }
})
