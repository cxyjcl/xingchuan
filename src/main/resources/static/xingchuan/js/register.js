/**
 * Created by pohoulong on 2018/3/6.
 */
$("#submit_btn").click(function () {
    var userValue = $("#login_name").val();
    var realValue = $("#real_name").val();
    var wordValue = $("#password").val();
    var rePassword = $("#re_password").val();
    var codeValue = $("#code").val();
    var production = $("#production").val();
    var strcheck = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
    var phonecheck = /^((1[3-8][0-9])+\d{8})$/;
    if (userValue == "") {
        alert("手机号不得为空");
    }
    else if (realValue == "") {
        alert("真实名不得为空");
    }
    else if (wordValue == "") {
        alert("密码不得为空");
    }
    else if (rePassword == "") {
        alert("密码不得为空");
    }
    else if (rePassword != wordValue) {
        alert("两次密码输入不正确");
    }
    else if (codeValue == "") {
        alert("验证码不得为空");
    }
    else if (!phonecheck.test(userValue)) {
        alert("手机号不符合规范");
    }
    else if (strcheck.test(wordValue)) {
        alert("密码不能包含空格\\<>等非法字符");
    }
    else if (strcheck.test(codeValue)) {
        alert("验证码不能包含空格\\<>等非法字符");
    }
    else {
        $.ajax({
            url: "http://localhost:8080/" + userValue + "/find",
            type: "GET",
            dataType: "json",
            success: function (data) {
                if (data.code != "10000") {
                    alert(data.msg);
                } else {
                    var _matcher = {
                        'code': codeValue,
                        'userPhone':userValue,
                    }
                    $.ajax({
                        url: "http://localhost:8080/code/matcher",
                        type: "POST",
                        dataType: "json",
                        contentType: "application/json",
                        data: JSON.stringify(_matcher),
                        success: function (data) {
                            if (data.code != "10000") {
                                alert(data.msg);
                            } else {
                                var _data = {
                                    'loginName': userValue,
                                    'realName': realValue,
                                    'password': wordValue,
                                    'production': production
                                };
                                $.ajax({
                                    url: "http://localhost:8080/register",
                                    type: "POST",
                                    contentType: "application/json",
                                    dataType: "json",
                                    data: JSON.stringify(_data),
                                    success: function (data) {
                                        if (data.code != "10000") {
                                            alert(data.msg);
                                        } else {
                                            alert("注册成功！");
                                        }
                                    }
                                });
                            }
                        }
                    })
                }
            }
        });
    }
});
$("#code_btn").click(function () {
    var userValue = $("#login_name").val();
    $.ajax({
        url: "http://localhost:8080/send/"+userValue+"/message",
        type: "POST",
        dataType: "json",
        success: function (data) {
            if (data.code != "10000") {
                alert(data.msg);
            }
        }
    });
})