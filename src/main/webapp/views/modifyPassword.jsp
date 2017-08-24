<%--
  Created by IntelliJ IDEA.
  User: roamer
  Date: 2017/8/23
  Time: 下午2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/login/login.css"/>
<script>
    function fun_resetpassword() {
        if ($("#newpassword").val() == $("#confirmpassword").val()) {
            Logger.debug("重置密码");
            $.ajax({
                type: 'post',
                url: contextPath + '/modifyPassword.json?' + jQuery.param({
                    "newpassword": $("#newpassword").val() ,
                }),
                async: true,//默认为true
                dataType: 'json',//默认为预期服务器返回的数据类型
                success: function (data) {
                    Messenger().post({
                        message: "密码修改成功",
                        type: "success",
                        showCloseButton: true
                    });
                    window.location = contextPath + "/";
                },
                error: function (data) {
                    Logger.debug("出现错误！");
                    if (JSON.parse(data.responseText).data[0].errorPath == "exception.system.need_login"){
                        Logger.debug("需要登录！");
                        showExceptionTip(data);
                        window.location = contextPath + "/views/login.jsp";
                    }else{
                        showExceptionTip(data);
                    }
                }
            });
        } else {
            Messenger().post({
                message: "2次密码不一致",
                type: "error",
                showCloseButton: true
            });
            $("#newpassword").focus();
            return false;
        }
    }
</script>
<div class="container">
    <div class="wrapper">
        <form method="post" name="Login_Form" class="form-signin">
            <h3 class="form-signin-heading">重置密码</h3>
            <hr class="colorgraph">
            <br>

            <input type="password" class="form-control" id="newpassword" placeholder="输入新密码" required="required"
                   autofocus=""/>
            <input type="password" class="form-control" id="confirmpassword" placeholder="再输一遍新密码" required="required"/>

            <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="button"
                    onclick="fun_resetpassword()">更新密码
            </button>
        </form>
    </div>
</div>
</body>
