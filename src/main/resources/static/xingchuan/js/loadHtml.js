if (!window.localStorage.getItem('terms')) {
  $('#contents').load('dialog.html');
  $('#dialog').show();
} else {
  console.log('已同意服务条款');
}