<%--
  Created by IntelliJ IDEA.
  User: roamer
  Date: 2017/8/8
  Time: 下午12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>

<script src="<%=request.getContextPath()%>/assets/js/parking_info/add.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/parking_info/add.css"/>

<script src="<%=request.getContextPath()%>/assets/js/lib/moment-2.18.1/moment.min.js"></script>

<form class="am-form" id="frm" onsubmit="fun_submit()">
    <fieldset>
        <div class="panel panel-default">
            <div class="panel-heading">停车位信息登记
                <input class="btn btn-success btn-save" type="submit" value="保存"/>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">车位基本信息</div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span">单元号</span>
                                <select id="building_no_select2" style="width:150px" class="select2">
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="input-group">
                            <div class="input-group input-group-sm ">
                                <span class="input-group-addon input-span">门牌号(格式:0101)</span>
                                <input type="text" class="form-control" placeholder="门牌号" id="room_no"
                                       name="room_no" aria-describedby="room_no" required="required"
                                       maxlength="4">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">居住类型</span>
                                <%@ include file="../modules/_living_type.jsp" %>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">停车位号</span>
                                <input type="text" class="form-control" placeholder=""
                                       aria-describedby="sizing-addon3"  style="width: 40px"
                                       maxlength="2">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon6">停车位类型</span>
                                <%@ include file="../modules/_parking_type.jsp" %>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon6">车位登记时间</span>
                                <input type="date" class="form-control edit-input" id="register_date" placeholder=""
                                       aria-describedby="sizing-addon6" 
                                       maxlength="18">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">产证信息</div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">产证号:沪房地（闵）字（</span>
                                <input type="text" class="form-control edit-input" placeholder=""
                                       aria-describedby="sizing-addon3"  style="width:60px"
                                       maxlength="4">
                                <span class="input-group-addon input-span" id="sizing-addon3">）第（</span>
                                <input type="text" class="form-control edit-input" placeholder=""
                                       aria-describedby="sizing-addon3"  style="width: 90px"
                                       maxlength="4">
                                <span class="input-group-addon input-span" id="sizing-addon3">）号</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon6">登记日期</span>
                                <input type="date" class="form-control edit-input" placeholder=""
                                       aria-describedby="sizing-addon6" 
                                       maxlength="18">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">产证所有人(和车辆行驶证对应)</span>
                                <input type="text" class="form-control" placeholder="输入姓名"
                                       aria-describedby="sizing-addon3" 
                                       maxlength="10">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon6">产证所有人证件号</span>
                                <input type="text" class="form-control" placeholder="输入证件号"
                                       aria-describedby="sizing-addon6" 
                                       maxlength="18">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="panel panel-default">
            <div class="panel-heading">行驶证信息</div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">行驶证号</span>
                                <input type="text" class="form-control" placeholder="输入行驶证号"
                                       aria-describedby="sizing-addon3"  style="width: 220px"
                                       maxlength="18">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon6">车牌号</span>
                                <input type="text" class="form-control" placeholder="输入车牌号"
                                       aria-describedby="sizing-addon6"  style="width: 150px"
                                       maxlength="8">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon6">行驶证登记日期</span>
                                <input type="date" class="form-control" placeholder=""
                                       aria-describedby="sizing-addon6" 
                                       maxlength="18">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon3">车辆所有人</span>
                                <input type="text" class="form-control" placeholder="输入名字"
                                       aria-describedby="sizing-addon3" 
                                       maxlength="10">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="input-group">
                            <div class="input-group input-group-sm">
                                <span class="input-group-addon input-span" id="sizing-addon6">车辆所有人证件号</span>
                                <input type="text" class="form-control" placeholder="输入证件号"
                                       aria-describedby="sizing-addon6" 
                                       maxlength="18">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </fieldset>

</form>
</body>
