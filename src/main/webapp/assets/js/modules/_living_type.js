$().ready(function () {
    var living_type_select2;

    $.ajax({
        type: "get",
        async: false,
        url: contextPath + '/living_type',
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
            living_type_select2 = $("#living_type_select2").select2({
                data: data,
                language: "zh-CN",//汉化
                placeholder: '请选择类型',//默认文字提示
                allowClear: false//允许清空
            });
            console.debug("缺省选择的是:" + living_type_select2.val());
            living_type_select2.on("change", function (e) {
                console.debug("选择了" + living_type_select2.val());
            });
        },
        error: function (data) {

        }
    });



})
