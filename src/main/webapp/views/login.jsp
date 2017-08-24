<%--
  Created by IntelliJ IDEA.
  User: roamer
  Date: 2017/8/22
  Time: 下午6:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/login/login.css"/>
<script>
    $().ready(function () {
    })

    function fun_login() {
        Logger.debug("开始登录！");
        var data = {};
        data.name = $("#Username").val();
        data.passwd = $("#Password").val();
        Logger.debug(data);

        $.ajax({
            type: 'post',
            data: JSON.stringify(data),
            url: contextPath + '/login.json',
            async: false,//默认为true
            contentType: "application/json",
            dataType: 'json',//默认为预期服务器返回的数据类型
            beforeSend: function (data) {
                cleanAllExceptionTip();
            },
            success: function (data) {
                window.location = contextPath + "/";
            },
            error: function (data) {
                Logger.debug("出现错误！");
                showExceptionTip(data);
            }
        });
    }
</script>

<div class="container">
    <div class="wrapper">
        <form method="post" name="Login_Form" class="form-signin">
            <h3 class="form-signin-heading">请登录</h3>
            <hr class="colorgraph">
            <br>

            <input type="text" class="form-control" id="Username" placeholder="用户名" required="required" autofocus=""/>
            <input type="password" class="form-control" id="Password" placeholder="密码" required="required"/>

            <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="button"
                    onclick="fun_login()">登录
            </button>
        </form>
    </div>
</div>
</body>
</html>
