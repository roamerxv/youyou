$().ready(function () {
    var approve_type_select2;

    $.ajax({
        type: "get",
        async: false,
        url: contextPath + '/approve_type',
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
            approve_type_select2 = $("#approve_type_select2").select2({
                data: data,
                language: "zh-CN",//汉化
                placeholder: '请选择审核状态',//默认文字提示
                allowClear: false//允许清空
            });
            console.debug("缺省选择的是:" + approve_type_select2.val());
            approve_type_select2.on("change", function (e) {
                console.debug("选择了" + approve_type_select2.val());
            });
        },
        error: function (data) {

        }
    });



})
