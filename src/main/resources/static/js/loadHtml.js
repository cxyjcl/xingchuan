if (!window.localStorage.getItem('terms')) {
  $('#contents').load('dialog.html');
  $('#dialog').show();
} else {
  console.log('已同意服务条款');
}

if (window.localStorage.getItem('loginName')) {
  $('#loginName').html(window.localStorage.getItem('loginName'));
  $('.user').css('display','block');
  $('.login').css('display','none');
}

function logout() {
  window.localStorage.clear();
  alert("退出成功！")
  location.reload();
}

function checkUser(){
  if (!window.localStorage.getItem('loginName')) {
    window.location.href = '/login.html';
  } else{
    window.location.href = '/product.html'
  }
}
function setContent(title, $el) {
  $('#title').text(title);
  $('#content').children().hide();
  $el.show();
}
$('.menu-nav-list li').click(function(e) {
  var tagname = $(e.target).attr('tagname');
  if (!tagname) return;
  setContent(e.target.innerHTML, $('#' + tagname));
});

