if (!window.localStorage.getItem('terms')) {
  $('#contents').load('dialog.html');
  $('#dialog').show();
} else {
  console.log('已同意服务条款');
}

function setContent(title, $el) {
  $('#title').text(title);
  $('#content').children().hide();
  $el.show();
}
$('.menu-nav-list li').click(function(e) {
  var tagname = $(e.target).attr('tagname');
  setContent(e.target.innerHTML, $('#' + tagname));
});