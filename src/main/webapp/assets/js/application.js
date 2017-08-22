Logger.useDefaults();
//Logger.setLevel(Logger.WARN);
var building_no_data = [{id: "01", text: '01单元'}, {id: "02", text: '02单元'}, {id: "03", text: '03单元'}, {
    id: "04",
    text: '04单元'
}, {id: "05", text: '05单元'}, {id: "06", text: '06单元'}, {id: "07", text: '07单元'}, {
    id: "08",
    text: '08单元'
}, {id: "09", text: '09单元'}];


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
    createNew: function () {
        var livingTypeEntity = BaseObj.createNew();
        return livingTypeEntity;
    }
}

//停车位类型
var ParkingTypeEntity = {
    createNew: function () {
        var parkingTypeEntity = BaseObj.createNew();
        return parkingTypeEntity;
    }
}

//审核状态
var ApproveTypeEntity = {
    createNew: function () {
        var approveTypeEntity = BaseObj.createNew();
        return approveTypeEntity;
    }
}

function fun_parseJsonToUI(data) {
    $("#building_no_select2").val(data.buildingNo).trigger("change");  //单元号
    $("#room_no").val(data.roomNo);
    $("#living_type_select2").val(data.livingTypeByLivingType.id).trigger("change");

    $("#parking_type_select2").val(data.parkingTypeByParkingType.id).trigger("change");
    $("#parking_no").val(data.parkingNo);
    $("#car_no").val(data.carNo);
    if (data.registerDate != null) {
        $("#register_date").val($.format.date(new Date(data.registerDate), 'yyyy-MM-dd'));
    }
    $("#approve_type_select2").val(data.approveTypeByApproveType.id).trigger("change");

    if (data.propertyCert != null) {
        $("#property_cert_1").val(data.propertyCert.split("-")[0]);
        $("#property_cert_2").val(data.propertyCert.split("-")[1]);
    }
    if (data.propertyCertRegisterAt != null) {
        $("#property_cert_register_at").val($.format.date(new Date(data.propertyCertRegisterAt), 'yyyy-MM-dd'));
    }

    $("#property_owner").val(data.propertyOwner);
    $("#property_owner_cid").val(data.propertyOwnerCid);

    $("#driving_license_no").val(data.drivingLicenseNo);
    if (data.drivingLicenseRegisterAt != null) {
        $("#driving_license_register_at").val($.format.date(new Date(data.drivingLicenseRegisterAt), 'yyyy-MM-dd'));
    }

    $("#driving_license_owner").val(data.drivingLicenseOwner);
    $("#comment").val(data.comment);

    $("#created_by").val(data.createdBy);
    $("#created_at").val(data.createdAt);

}

function getUIValue2Json() {
    var parkingInfo = ParkingInfo.createNew();
    parkingInfo.buildingNo = $("#building_no_select2 option:selected").val();
    parkingInfo.roomNo = $("#room_no").val();
    parkingInfo.registerDate = $("#register_date").val();
    Logger.debug($("#living_type_select2 option:selected").val());

    var livingTypeEntity = LivingTypeEntity.createNew();
    livingTypeEntity.id = $("#living_type_select2 option:selected").val();
    parkingInfo.livingTypeByLivingType = livingTypeEntity;

    var parkingTypeEntity = ParkingTypeEntity.createNew();
    parkingTypeEntity.id = $("#parking_type_select2 option:selected").val();
    parkingInfo.parkingTypeByParkingType = parkingTypeEntity;

    var approveTypeEntity = ApproveTypeEntity.createNew();
    approveTypeEntity.id = $("#approve_type_select2 option:selected").val();
    parkingInfo.approveTypeByApproveType = approveTypeEntity;

    parkingInfo.parkingNo = $("#parking_no").val();
    parkingInfo.carNo = $("#car_no").val();

    parkingInfo.propertyCert = $("#property_cert_1").val() + "-" + $("#property_cert_2").val();
    parkingInfo.propertyCertRegisterAt = $("#property_cert_register_at").val();
    parkingInfo.propertyOwner = $("#property_owner").val();
    parkingInfo.propertyOwnerCid = $("#property_owner_cid").val();

    parkingInfo.drivingLicenseNo = $("#driving_license_no").val();
    parkingInfo.drivingLicenseRegisterAt = $("#driving_license_register_at").val();
    parkingInfo.drivingLicenseOwner = $("#driving_license_owner").val();
    parkingInfo.comment = $("#comment").val();

    parkingInfo.createdAt = $("#created_at").val();
    parkingInfo.createdBy = $("#created_by").val();

    return parkingInfo;
}
