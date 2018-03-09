/**
 * Created by pohoulong on 2018/3/6.
 */
$("#submit_btn").click(function () {
    var loginName = $("#phone_number").val();
    var password = $("#password").val();;
    var strcheck = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
    if (loginName == "") {
        alert("用户名不得为空");
    }
    else if (password == "") {
        alert("密码不得为空");
    }
    else if (strcheck.test(loginName)) {
        alert("用户名不能包含空格\\<>等非法字符");
    }
    else if (strcheck.test(password)) {
        alert("密码不能包含空格\\<>等非法字符");
    }
    else {
        var _data = {
            'loginName': loginName,
            'password': password,
        };
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': "*"
            },
            url: "http://119.23.229.247:8080/user/login",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(_data),
            success: function (data) {
                if (data.code != "10000") {
                    alert(data.msg);
                } else {
                    localStorage.setItem('loginName', data.data);
                    alert("登陆成功！");
                    window.location.href="/index.html"
                }
            }
        });
    }
});