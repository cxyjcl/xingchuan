function setContent(title, $el) {
  $('#title').text(title);
  $('#content').children().hide();
  $el.show();
}