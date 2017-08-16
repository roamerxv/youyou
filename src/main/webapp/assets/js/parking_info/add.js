var ParkingInfo = {
    createNew: function () {
        var parkingInfo = {};
        parkingInfo.toString = function () {
            return JSON.stringify(parkingInfo);
        }
        return parkingInfo;
    }
};


function fun_submit() {
    Logger.debug("保存记录！");

    var parkingInfo = ParkingInfo.createNew();

    parkingInfo.buildingNo = $("#building_no_select2 option:selected").val();
    parkingInfo.roomNo = $("#room_no").val();
    parkingInfo.registerDate = $("#register_date").val();
    Logger.debug(parkingInfo.toString());
    $.ajax({
        type: 'post',
        data: parkingInfo.toString(),
        url: contextPath + '/parking_info',
        async: false,//默认为true
        contentType: "application/json",
        dataType: 'json',//默认为预期服务器返回的数据类型
        success: function (data) {
            console.log(data.data.completePercent);
        },
        error: function (data) {

        }
    });
}

$().ready(function () {
    var today = moment().format('YYYY-MM-DD');
    $('#register_date').val(today);

    var data = [{id: "01", text: '01单元'}, {id: "02", text: '02单元'}, {id: "03", text: '03单元'}, {
        id: "04",
        text: '04单元'
    }, {id: "05", text: '05单元'}, {id: "06", text: '06单元'}, {id: "07", text: '07单元'}, {
        id: "08",
        text: '08单元'
    }, {id: "09", text: '09单元'}];

    var building_no_select2 = $("#building_no_select2").select2({
        data: data,
        language: "zh-CN",//汉化
        placeholder: '请选择类型',//默认文字提示
        allowClear: false//允许清空
    });
})
