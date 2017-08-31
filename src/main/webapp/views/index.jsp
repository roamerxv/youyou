<%--
  ~ Boracay - Web 项目实用组件框架
  ~
  ~ @author 徐泽宇 roamerxv@gmail.com
  ~ @version 1.0.0
  ~ Copyright (c) 2017. 徐泽宇
  ~
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>

<style>
    .content {
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        margin: auto;
        height: 240px;
        width: 70%;
    }
</style>
<div class="admin-content">
    <div class="admin-content-body">

        <ul class="content" style="text-align:center;">
            <img src="<%=request.getContextPath()%>/assets/imgs/gongping.jpg"/>

        </ul>
    </div>

    <footer class="admin-content-footer">
        <hr>
        <p class="am-padding-left">© 2017 Roamer GPL.</p>
    </footer>
</div>
</body>
