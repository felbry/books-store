$(function(){
  $('input').on('focus', function(){
    $('.warning').css('display', 'none');
  });

  $('#login').on('click', function(){
    var user = $('input[id="username"]').val(),
			  pass = $('input[id="password"]').val();
		var userInfo = {
			username: user,
			password: pass,
		}
		var userInfoStr = JSON.stringify(userInfo);
		$.post('login', {userInfomation: userInfoStr}, function(data){
			console.log(data);
      if(data == 'istrue')
        window.location.href = "index.jsp";
      else if(data == 'isfalse')
        $('.warning').css('display', 'flex');
		})
  })
  
  $('#register').on('click', function() {
	  window.location.href = "register.jsp";
  })
})
