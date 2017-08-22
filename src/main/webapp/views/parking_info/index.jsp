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
            <th>居住类型</th>
            <th>车位类型</th>
            <th>停车位号</th>
            <th>车牌号</th>
            <th>审核状态</th>
            <th>操作</th>
            <%--<th>备注</th>--%>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th>单元</th>
            <th>房号</th>
            <th>居住类型</th>
            <th>车位类型</th>
            <th>停车位号</th>
            <th>车牌号</th>
            <th>审核状态</th>
            <th>操作</th>
            <%--<th>备注</th>--%>
        </tr>
        </tfoot>

    </table>
</div>

<style>
    .modal-dialog {
        margin-top: 100px;
    }
</style>

<script>
    var parking_info_table ;

    function fun_delete(id) {
        bootbox.confirm({
            message: "确认要删除这条记录吗?一经删除，就无法恢复！",
            buttons: {
                confirm: {
                    label: '删除',
                    className: 'btn-success'
                },
                cancel: {
                    label: '不删了',
                    className: 'btn-danger'
                }
            },
            callback: function (result) {
                if (result){
                    $.ajax({
                        url: contextPath + "/parking_infos/"+id,
                        method: "delete"
                    }).done(function() {
                        parking_info_table.ajax.reload();
                    });
                }
            }
        });
    };

    function fun_edit(id) {
        window.location = "<%=request.getContextPath()%>/views/parking_info/edit.jsp?"+id;
    }

    $().ready(function () {
        parking_info_table = $("#parking_info_table").DataTable({
            "processing": true,
            "serverSide": false,
            "ajax": {
                url: contextPath + "/parking_infos/.json",
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
            }, {
                "data": "livingTypeByLivingType.name"
            }, {
                "data": "parkingTypeByParkingType.name"
            }, {
                "data": "parkingNo"
            }, {
                "data": "carNo"
            }, {
                "data": "approveTypeByApproveType.name"
            }],
            "columnDefs": [{
                orderable: false,
                targets: [7]
            }, {
                "render": function (data, type, row) {
                    console.debug(row);
                    return '<input class="btn  btn-xs btn-primary btn-edit" type="button" value="编辑" onclick="fun_edit(\'' + row.id + '\')"><input class="btn btn-xs btn-danger" type="button" value="删除" onclick="fun_delete(\'' + row.id + '\')">'
                },
                "targets": 7
            }]
        });


    });
</script>
</body>
