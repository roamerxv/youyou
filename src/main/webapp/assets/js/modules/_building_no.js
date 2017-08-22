$().ready(function () {

    var building_no_select2 = $("#building_no_select2").select2({
        data: building_no_data,
        language: "zh-CN",//汉化
        placeholder: '请选择类型',//默认文字提示
        allowClear: false//允许清空
    });

})
