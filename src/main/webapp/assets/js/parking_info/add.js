var BaseObj = {
    createNew: function () {
        var baseObj = {};
        baseObj.toString = function () {
            return JSON.stringify(baseObj);
        }
        return baseObj;
    }
}

// 车位信息
var ParkingInfo = {
    createNew: function () {
        var parkingInfo = BaseObj.createNew();
        return parkingInfo;
    }
};

//居住类型
var LivingTypeEntity = {
    createNew: function(){
        var livingTypeEntity =BaseObj.createNew();
        return livingTypeEntity;
    }
}

//停车位类型
var ParkingTypeEntity = {
    createNew: function(){
        var parkingTypeEntity = BaseObj.createNew();
        return parkingTypeEntity ;
    }
}

//审核状态
var ApproveTypeEntity = {
    createNew: function(){
        var approveTypeEntity = BaseObj.createNew();
        return approveTypeEntity ;
    }
}

function fun_submit() {
    Logger.debug("保存记录！");

    var parkingInfo = ParkingInfo.createNew();

    parkingInfo.buildingNo = $("#building_no_select2 option:selected").val();
    parkingInfo.roomNo = $("#room_no").val();
    parkingInfo.registerDate = $("#register_date").val();
    Logger.debug($("#living_type_select2 option:selected").val());

    var livingTypeEntity = LivingTypeEntity.createNew();
    livingTypeEntity.id = $("#living_type_select2 option:selected").val();
    parkingInfo.livingTypeByLivingType = livingTypeEntity ;

    var parkingTypeEntity = ParkingTypeEntity.createNew();
    parkingTypeEntity.id = $("#parking_type_select2 option:selected").val();
    parkingInfo.parkingTypeByParkingType = parkingTypeEntity;

    var approveTypeEntity = ApproveTypeEntity.createNew();
    approveTypeEntity.id = $("#approve_type_select2 option:selected").val();
    parkingInfo.approveTypeByApproveType = approveTypeEntity;

    parkingInfo.parkingNo = $("#parking_no").val();
    parkingInfo.carNo = $("#car_no").val();

    Logger.debug(parkingInfo.toString());
    $.ajax({
        type: 'post',
        data: parkingInfo.toString(),
        url: contextPath + '/parking_info',
        async: false,//默认为true
        contentType: "application/json",
        dataType: 'json',//默认为预期服务器返回的数据类型
        success: function (data) {
            window.location= contextPath+"/";
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
