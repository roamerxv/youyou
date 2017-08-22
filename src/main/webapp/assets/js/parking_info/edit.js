var id;
$().ready(function () {
    id = location.search.substr(1);
    $.ajax({
        type: 'get',
        url: contextPath + '/parking_infos/' + id,
        async: true,//是否异步，默认为true
        contentType: "application/json",
        dataType: 'json',//默认为预期服务器返回的数据类型
        success: function (data) {
            Logger.debug(data);
            fun_parseJsonToUI(data);
            $(":disabled").removeAttr("disabled")
        },
        error: function (data) {

        }
    });
})

function fun_submit() {
    Logger.debug("提交更新!" + id);
    var parkingInfo = getUIValue2Json();
    parkingInfo.id = id ;
    Logger.debug(parkingInfo.toString());
    $.ajax({
        type: 'put',
        data: parkingInfo.toString(),
        url: contextPath + '/parking_infos/'+id,
        async: false,//默认为true
        contentType: "application/json",
        dataType: 'json',//默认为预期服务器返回的数据类型
        success: function (data) {
            window.location = contextPath + "/";
        },
        error: function (data) {

        }
    });
}

