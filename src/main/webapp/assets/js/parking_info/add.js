function fun_submit() {
    Logger.debug("保存记录！");



    var parkingInfo = getUIValue2Json();
    Logger.debug(parkingInfo.toString());

    $.ajax({
        type: 'post',
        data: parkingInfo.toString(),
        url: contextPath + '/parking_infos.json',
        async: false,//默认为true
        contentType: "application/json",
        dataType: 'json',//默认为预期服务器返回的数据类型
        success: function (data) {
            window.location = contextPath + "/";
        },
        error: function (data) {
            Logger.debug("出现错误！");
            if (JSON.parse(data.responseText).data[0].errorPath == "exception.system.need_login"){
                Logger.debug("需要登录！");
                showExceptionTip(data);
                window.location = contextPath + "/views/login.jsp";
            }
        }
    });
}

$().ready(function () {
    var today = moment().format('YYYY-MM-DD');
    $('#register_date').val(today);

})
