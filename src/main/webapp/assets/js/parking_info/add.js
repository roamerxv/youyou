function fun_submit() {
    Logger.debug("保存记录！");

    var parkingInfo = getUIValue2Json();
    Logger.debug(parkingInfo.toString());

    $.ajax({
        type: 'post',
        data: parkingInfo.toString(),
        url: contextPath + '/parking_infos',
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

$().ready(function () {
    var today = moment().format('YYYY-MM-DD');
    $('#register_date').val(today);

})
