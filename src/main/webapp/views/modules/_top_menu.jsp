<%--
  Created by IntelliJ IDEA.
  User: roamer
  Date: 2017/8/24
  Time: 下午12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pers.roamer.boracay.configer.ConfigHelper" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/modules/_top_menu.css">

<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <a href="<%=request.getContextPath()%>/">
            <strong>中祥龙柏苑</strong>
        </a>
    </div>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
            <li class="am-hide-sm-only">
                <a href="<%=request.getContextPath()%>/views/parking_info/parked_index.jsp">
                    <span class="am-icon-car">已停车位信息</span>
                </a>
            </li>
            <li class="am-hide-sm-only">
                <a href="<%=request.getContextPath()%>/views/parking_info/lining_index.jsp">
                    <span class="am-icon-car">排队车辆信息</span>
                </a>
            </li>

            <% String name = (String) session.getAttribute(ConfigHelper.getConfig().getString("System.SessionUserKeyword"));
                if (name != null) {%>
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="<%=request.getContextPath()%>/views/modifyPassword.jsp"><span
                            class="am-icon-cog"></span>修改密码</a></li>
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
                    <li><a href="<%=request.getContextPath()%>/views/login.jsp"><span class="am-icon-user"></span>登录</a>
                    </li>
                    </li>
                </ul>
            </li>
            <%} %>
            <li class="am-hide-sm-only">
                <a href="<%=request.getContextPath()%>/views/system/systemLoggerIndex.jsp" id="show_log">
                    <span class="am-icon-table"></span> <span class="admin-fullText">显示日志</span>
                </a>
            </li>
            <%--<li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span--%>
                    <%--class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>--%>
        </ul>
    </div>
</header>

</body>
