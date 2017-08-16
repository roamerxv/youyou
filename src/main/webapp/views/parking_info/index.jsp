<%--
  Created by IntelliJ IDEA.
  User: roamer
  Date: 2017/8/3
  Time: 下午3:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div class="dataTable_div">
    <table id="parking_info_table" class="table table-striped table-bordered hover">
        <thead>
        <tr>
            <th>单元</th>
            <th>房号</th>
            <%--<th>居住类型</th>--%>
            <%--<th>停车位类别</th>--%>
            <%--<th>停车位号</th>--%>
            <%--<th>车牌号</th>--%>
            <%--<th>产证号</th>--%>
            <%--<th>产证登记日期</th>--%>
            <%--<th>产证所有人</th>--%>
            <%--<th>行驶证号</th>--%>
            <%--<th>行驶证所有人</th>--%>
            <%--<th>备注</th>--%>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th>单元</th>
            <th>房号</th>
            <%--<th>居住类型</th>--%>
            <%--<th>停车位类别</th>--%>
            <%--<th>停车位号</th>--%>
            <%--<th>车牌号</th>--%>
            <%--<th>产证号</th>--%>
            <%--<th>产证登记日期</th>--%>
            <%--<th>产证所有人</th>--%>
            <%--<th>行驶证号</th>--%>
            <%--<th>行驶证所有人</th>--%>
            <%--<th>备注</th>--%>
        </tr>
        </tfoot>

    </table>
</div>
<script>
    $().ready(function () {
        parking_info_table = $("#parking_info_table").DataTable({
            "processing": true,
            "serverSide": false,
            "ajax": {
                url: contextPath + "/parking_infos.json",
                type: 'get',
                dataType: "json",
                processData: true,
                contentType: 'application/json;charset=UTF-8',
                dataSrc: 'data'
            },
            "language": {
                "url": contextPath + "/assets/js/lib//DataTables-1.10.15/chinese.lang.json"
            },
            "columns": [{
                "data": "buildingNo"
            }, {
                "data": "roomNo"
            }]
        });
    });
</script>
</body>
