<%@ page import="pers.roamer.boracay.configer.ConfigHelper" %><%--
  ~ Boracay - Web 项目实用组件框架
  ~
  ~ @author 徐泽宇 roamerxv@gmail.com
  ~ @version 1.0.0
  ~ Copyright (c) 2017. 徐泽宇
  ~
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js fixed-layout">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>中祥龙柏苑车位登记信息</title>
    <meta name="description" content="Boracay Web Smaple">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/assets/AmazeUI-2.7.2/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed"
          href="<%=request.getContextPath()%>/assets/AmazeUI-2.7.2/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/AmazeUI-2.7.2/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/AmazeUI-2.7.2/assets/css/admin.css">

    <script src="<%=request.getContextPath()%>/assets/js/lib/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/AmazeUI-2.7.2/assets/js/amazeui.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/AmazeUI-2.7.2/assets/js/app.js"></script>
    <%@ include file="../layouts/_included_js.jsp" %>
</head>


<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
    以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <a href="<%=request.getContextPath()%>/">
            <strong>中祥龙柏苑</strong>
            <small>车位信息公示</small>
        </a>
    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
            <li class="am-hide-sm-only">
                <a href="<%=request.getContextPath()%>/views/system/systemLoggerIndex.jsp" id="show_log">
                    <span class="am-icon-table"></span> <span class="admin-fullText">显示日志</span>
                </a>
            </li>
            <% String name = (String) session.getAttribute(ConfigHelper.getConfig().getString("System.SessionUserKeyword"));
                if (name != null) {%>
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="#"><span class="am-icon-user"></span>资料</a></li>
                    <li><a href="<%=request.getContextPath()%>/views/modifyPassword.jsp"><span class="am-icon-cog"></span>修改密码</a></li>
                    <li><a href="<%=request.getContextPath()%>/views/parking_info/add.jsp"><span
                            class="am-icon-car"></span>增加</a></li>
                    <li><a href="<%=request.getContextPath()%>/logout"><span class="am-icon-power-off"></span>退出</a>
                    </li>
                </ul>
            </li>
            <%} else { %>
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="<%=request.getContextPath()%>/views/login.jsp"><span class="am-icon-user"></span>登录</a></li>
                    </li>
                </ul>
            </li>
            <%} %>

            <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span
                    class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
        </ul>
    </div>
</header>

<div class="am-cf admin-main">
    <!-- sidebar start -->

    <!-- sidebar end -->

    <!-- content start -->
    <div class="admin-content" style="padding: 5px">
        <sitemesh:write property='body'/>
    </div>


    <!-- content end -->

</div>

</body>
</html>
